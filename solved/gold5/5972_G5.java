import java.io.*;
import java.util.*;


public class Main{
	
	static class Graph{
		int end, weight;
		
		Graph(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
	}
	
	static class Node implements Comparable<Node>{
		int end, total;
		
		Node(int end, int total){
			this.end = end;
			this.total = total;
		}

		@Override
		public int compareTo(Node o) {
			return this.total - o.total;
		}
	}
	
	static int N, M;
	static int[] list, dist;
	static ArrayList<Graph>[] Graphs;
	static PriorityQueue<Node> pq;
	static final int INF = 1_000_000_000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		pq = new PriorityQueue<>();

		list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		N = list[0];
		M = list[1];
		
		Graphs = new ArrayList[N+1];
		dist = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			Graphs[i] = new ArrayList<>();
			dist[i] = INF;
		}
		
		for(int i = 0; i < M; i++) {
			list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			Graphs[list[0]].add(new Graph(list[1], list[2]));
			Graphs[list[1]].add(new Graph(list[0], list[2]));
		}
		
		pq.add(new Node(1, 0));
		dist[1] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(n.end == N) {
				break;
			}
			
			for(Graph g : Graphs[n.end]) {
				int total = g.weight + n.total;
				
				if(dist[g.end] > total) {
					dist[g.end] = total;
					pq.add(new Node(g.end, total));
				}
			}
		}
		
		System.out.println(dist[N]);		
	}
}
