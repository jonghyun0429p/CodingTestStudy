import java.util.*;
import java.io.*;

public class Main{

	static final int INF = 1000000000;
	static int N, A, B, C, L;
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
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		Graphs = new ArrayList[N+1];
		Dist = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			Graphs[i] = new ArrayList<Graph>();
		}
		Arrays.fill(Dist, INF);
		
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			Graphs[x].add(new Graph(y, z));
			Graphs[y].add(new Graph(x, z));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(A, 0));
		pq.add(new Node(B, 0));
		pq.add(new Node(C, 0));
		
		Dist[A] = 0;
		Dist[B] = 0;
		Dist[C] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(Dist[n.next] > n.total) continue;
			
			for(Graph g : Graphs[n.next]) {
				long cur = g.dist + n.total;
				
				if(Dist[g.next] > cur) {
					Dist[g.next] = cur;
					pq.add(new Node(g.next, cur));
				}
			}
		}
		
		int num = 0;
		long max = 0;
		
		for(int i = 1; i <= N; i++) {
			if(Dist[i] > max) {
				max = Dist[i];
				num = i;
			}
		}
		
		System.out.println(num);
	}
}