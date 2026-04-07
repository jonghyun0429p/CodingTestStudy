import java.io.*;
import java.util.*;

//최소 개수의 회선 복구.
//최소 시간 회선의 복구. -> 최소한의 갯수를 생성했을 때, 원래 통신하는 시간이 줄어들면 안된다.
//즉, 최단 거리를 보장하던 회선이 사라지면 안된다는 의미.
//무조건 1이 슈퍼 컴퓨터니까 각 점에서 최단 거리가 존재할거고,
//아 싹 다 지우고 최단 거리 유지에만 필요한 회선만 살린다고 생각하면 됨.
//parent를 관리하면 됨... ㅡㅡ 
//사실 parent를 들렀을때 가장 최소여야 다음으로 갔을 때도 비교할 만큼 작은 결과값이라.

public class Main{
	
	static class Graph{
		int next, time;
		
		Graph(int next,int time){
			this.next = next;
			this.time = time;
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
	
	static int N, M, cnt;
	static ArrayList<Graph>[] Graphs;
	static int[] parent, dist, list;
	static PriorityQueue<Node> pq;
	static final int INF = 1_000_000_000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		pq = new PriorityQueue<>();
		
		cnt = 0;
		
		list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		N = list[0];
		M = list[1];
		dist = new int[N+1];
		parent = new int[N+1];
		Graphs = new ArrayList[N+1];
		
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
			
			for(Graph g : Graphs[n.next]) {
				int total = n.total + g.time;
				
				if(dist[g.next] > total) {
					dist[g.next] = total;
					parent[g.next] = n.next;
					pq.add(new Node(g.next, total));
				}
			}
		}
		
		for(int i = 2; i <= N; i++) {
			cnt++;
			sb.append(parent[i]).append(" ").append(i).append("\n");
		}
		System.out.println(cnt);
		System.out.println(sb);
	}
}
