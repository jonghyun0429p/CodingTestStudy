import java.util.*;
import java.io.*;

public class Main{
	static final long INF = Long.MAX_VALUE;
	static int N, M;
	static boolean[] isFind;
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
		M = Integer.parseInt(st.nextToken());
		
		isFind = new boolean[N];
		Dist = new long[N];
		Graphs = new ArrayList[N];
		
		Arrays.fill(Dist, INF);
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++){
			if(st.nextToken().equals("1")) {
				isFind[i] = true;
			}
			Graphs[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			Graphs[a].add(new Graph(b, t));
			Graphs[b].add(new Graph(a, t));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Dist[0] = 0;
		pq.add(new Node(0, 0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(n.next == N-1) {
				sb.append(n.total);
				break;
			}
			
			if(Dist[n.next] < n.total) continue;
			
			for(Graph g : Graphs[n.next]) {
				long cur = g.dist + n.total;
				
				if(isFind[g.next] && g.next != N-1) continue;
				
				if(Dist[g.next] > cur) {
					Dist[g.next] = cur;
					pq.add(new Node(g.next, cur));
				}
			}
		}
		
		if(sb.length() > 0) {
			System.out.println(sb);
		}else {
			System.out.println(-1);
		}
	}
}