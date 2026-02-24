import java.io.*;
import java.util.*;

public class Main {
	
	static final long INF = Long.MAX_VALUE / 4;
	static int N, M, K, A, B, C, NUM;
	static long MAX, DIST;
	static int[] List;
	static long[] Dist;
	static ArrayList<Graph>[] Graphs;
	
	static class Graph{
		int next, dist;
		
		Graph(int next, int dist){
			this.next = next;
			this.dist = dist;
		}
	}
	
	static class Node implements Comparable<Node>{
		int next;
		long total;
		
		Node(int next, long total){
			this.next = next;
			this.total = total;
		}

		@Override
		public int compareTo(Node o) {
		    return Long.compare(this.total, o.total);
		}
	}	

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        Dist = new long[N+1];
        Graphs = new ArrayList[N+1];
        
        for(int i = 0; i <= N; i++) {
        	Dist[i] = INF;
        	Graphs[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {        	
        	st = new StringTokenizer(br.readLine());
        	
        	A = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());
        	C = Integer.parseInt(st.nextToken());
        	
        	Graphs[B].add(new Graph(A, C));
        }
        
        st = new StringTokenizer(br.readLine());
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        
        while(st.hasMoreTokens()) {
        	A = Integer.parseInt(st.nextToken());
        	
        	Dist[A] = 0;
        	pq.add(new Node(A, 0));
        }
        
        while(!pq.isEmpty()){
        	Node n = pq.poll();
        	
        	if(Dist[n.next] < n.total) continue;
        	
        	for(Graph g : Graphs[n.next]) {
        		long cur = g.dist + n.total;
        		
        		if(Dist[g.next] > cur) {
        			Dist[g.next] = cur;
        			pq.add(new Node(g.next, cur));
        		}
        	}
        }
        
        for(int i = 1; i <= N; i++) {
        	if(Dist[i] == INF) continue;
        	
        	if(Dist[i] > MAX) {
        		MAX = Dist[i];
        		NUM = i;
        		DIST = Dist[i];
        	}
        }
        System.out.println(NUM);
        System.out.println(DIST);
    }
}