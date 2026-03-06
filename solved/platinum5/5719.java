import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 1000000000;
    static int N, M, A, B, MIN, SEC;
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
        StringBuilder sb = new StringBuilder();
	    while(true) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        
	        if(N == 0 && M == 0) break;
	        st = new StringTokenizer(br.readLine());
	        A = Integer.parseInt(st.nextToken());
	        B = Integer.parseInt(st.nextToken());
	
	        Graphs = new ArrayList[N];
	        Dist = new int[N];
	        Parents = new int[N];
	        
	        for(int i = 0; i < N; i++) {
	        	Graphs[i] = new ArrayList<Graph>();
	        	Dist[i] = INF;
	        	Parents[i] = i;
	        }
	        
	        for(int i = 0; i < M; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	
	        	int x = Integer.parseInt(st.nextToken());
	        	int y = Integer.parseInt(st.nextToken());
	        	int z = Integer.parseInt(st.nextToken());
	        	
	        	Graphs[x].add(new Graph(y, z));
	        }
	        
	        PQ = new PriorityQueue<Node>();
	        
	        PQ.add(new Node(A, 0));
	        Dist[A] = 0;
	        
	        while(!PQ.isEmpty()) {
	        	Node n = PQ.poll();
	        	
	        	if(Dist[n.next] < n.total) continue;
	        	
	        	if(n.next == B) break;
	        	
	        	for(Graph g : Graphs[n.next]) {
	        		int cur = g.dist + n.total;
	        		
	        		if(Dist[g.next] > cur) {
	        			Dist[g.next] = cur;
	        			Parents[g.next] = n.next;
	        			PQ.add(new Node(g.next, cur));
	        		}
	        	}
	        }
	        
	        MIN = Dist[B];
	        
	        PQ = new PriorityQueue<Node>();
	        
	        Arrays.fill(Dist, INF);
	        
	        PQ.add(new Node(A, 0));
	        Dist[A] = 0;
	        
	        while(!PQ.isEmpty()) {
	        	Node n = PQ.poll();
	        	
	        	if(Dist[n.next] < n.total) continue;
	        	if(n.next == B) break;
	        	
	        	for(Graph g : Graphs[n.next]) {
	        		
	        		if(isBan(n.next, g.next)) continue;
	        		
	        		int cur = g.dist + n.total;
	        		
	        		if(Dist[g.next] > cur) {
	        			if(g.next == B && cur == MIN) continue;
	        			Dist[g.next] = cur;
	        			PQ.add(new Node(g.next, cur));
	        		}
	        	}
	        }
	         
	        if(Dist[B] == INF) {
	        	sb.append(-1).append("\n");
	        }else {
	        	sb.append(Dist[B]).append("\n");
	        }
	    }
	    sb.deleteCharAt(sb.length()-1);
	    System.out.println(sb);
    }
    
    static boolean isBan(int a, int b) {
    	int cur = B;
    	
    	while(cur != A) {
    		if(a == cur && b == Parents[cur]) {
    			return true;
    		}else if(b == cur && a == Parents[cur]) {
    			return true;
    		}
    		cur = Parents[cur];
    	}
    	
    	return false;
    }
}