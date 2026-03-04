import java.io.*;
import java.util.*;

//최단 경로를 하나 씩 자르고 다시 다익스트라를 구하기
//그렇게 해서 가장 큰 값을 값으로 주면 될거같은데
//경로 자르면서 하나씩 다익스트라를 하면 너무 오래걸리지않으려나
//저장하는 방법을 parent?
//메모리가 256MB 정점 1000개 도로 1000*999/2 = 499500

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static int N, M, MAX;
	static int[] Dist, Parents;
	static ArrayList<Graph>[] Graphs;
    static PriorityQueue<Node> PQ;
	
	static class Graph{
		int next, dist;
		
		Graph(int next, int dist){
			this.next = next;
			this.dist = dist;
		}
	}
	
	static class Node implements Comparable<Node>{
		int next, total;
		
		Node(int next, int total){
			this.next = next;
			this.total = total;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.total - o.total;
		}
	}

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x, y, z;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        Dist = new int[N+1];
        Parents = new int[N+1];
        Graphs = new ArrayList[N+1];
        PQ = new PriorityQueue<Node>();
        
        for(int i = 0; i <= N; i++) {
        	Dist[i] = INF;
        	Parents[i] = i;
        	Graphs[i] = new ArrayList<Graph>();
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());
        	z = Integer.parseInt(st.nextToken());
        	
        	Graphs[x].add(new Graph(y,z));
        	Graphs[y].add(new Graph(x,z));
        }
        
        Dist[1] = 0;
        PQ.add(new Node(1, 0));
        
    	while(!PQ.isEmpty()) {
    		Node n = PQ.poll();
    		
    		if(n.next == N) break;
    		if(Dist[n.next] < n.total) continue;
    		
    		for(Graph g : Graphs[n.next]) {
    			int cur = n.total + g.dist;
    			
    			if(Dist[g.next] > cur) {
    				Dist[g.next] = cur;
    				Parents[g.next] = n.next;
    				PQ.add(new Node(g.next, cur));
    			}
    		}
    	}
    	
    	MAX = -1;

    	int now = N;
    	while(now != 1) {
    		if(MAX == INF) {
    			MAX = -1;
    			break;
    		}
    		getDist(now, Parents[now]);    		
    		MAX = Math.max(MAX, Dist[N]);
    		now = Parents[now];
    	}
    	
    	System.out.println(MAX);
    }
    
    static void getDist(int cutX, int cutY) {
    	Arrays.fill(Dist, INF);
        PQ = new PriorityQueue<Node>();
    	PQ.add(new Node(1, 0));
    	Dist[1] = 0;
    	
    	while(!PQ.isEmpty()) {
    		Node n = PQ.poll();
    		
    		if(n.next == N) break;
    		if(Dist[n.next] < n.total) continue;
    		
    		for(Graph g : Graphs[n.next]) {
    			
    			if(n.next == cutX && g.next == cutY) continue;
    			if(n.next == cutY && g.next == cutX) continue;
    			
    			int cur = n.total + g.dist;
    			
    			if(Dist[g.next] > cur) {
    				Dist[g.next] = cur;
    				PQ.add(new Node(g.next, cur));
    			}
    		}
    	}
    }
}