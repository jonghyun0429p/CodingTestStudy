import java.io.*;
import java.util.*;

// 다익스트라 돌리면 dist가 나오는데, cost hisory가 있어야하는데 어떻게 관리할건지.
// 이걸 큰 순으로 정렬하고, k+1번째 값을 구하면 됨.

public class Main {
	
	static final long INF = Long.MAX_VALUE/4;
	static int N, P, K, A, B, C;
	static long[][] Dist;
	static ArrayList<Graph>[] Graphs;
	static PriorityQueue<Node> PQ;
	
	static class Graph{
		int next, cost;
		
		Graph(int next, int cost){
			this.next = next;
			this.cost = cost;
		}
	}
	
	static class Node implements Comparable<Node>{
		int next, used;
		long total;
		
		Node(int next, int used, long total){
			this.next = next;
			this.used = used;
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
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        Dist = new long[N+1][K+1];
        Graphs = new ArrayList[N+1];
        
        for(int i = 1; i <= N; i++) {
        	for(int j = 0; j <= K; j++) {
                Dist[i][j] = INF;        		
        	}
        	Graphs[i] = new ArrayList<Graph>();
        }
        
        for(int i = 0; i < P; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	A = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());
        	C = Integer.parseInt(st.nextToken());
        	
        	Graphs[A].add(new Graph(B, C));
        	Graphs[B].add(new Graph(A, C));
        }
        
        Dist[1][0] = 0;
        PQ = new PriorityQueue<Node>();
        
        PQ.add(new Node(1, 0, 0L));
        
        while(!PQ.isEmpty()) {
        	Node n = PQ.poll();
        	
        	if(Dist[n.next][n.used] < n.total) continue;
        	
        	for(Graph g: Graphs[n.next]) {
        	    long cur = Math.max(n.total, g.cost);
        		
        		if(Dist[g.next][n.used] > cur) {
        			Dist[g.next][n.used] = cur;
        			
        			PQ.add(new Node(g.next, n.used, cur));
        		}
        		
        		if(n.used < K) {
        			cur = n.total;
        			if(Dist[g.next][n.used+1] > cur) {
            			Dist[g.next][n.used+1] = cur;
            			
            			PQ.add(new Node(g.next, n.used+1, cur));
            		}
        		}
        	}
        }
        
        
        
        long answer = INF;
        
        for(int i = 0; i <= K; i++) {
        	answer = Math.min(answer, Dist[N][i]);
        }
        
        if(answer == INF) System.out.println(-1);
        else System.out.println(answer);
    }
}