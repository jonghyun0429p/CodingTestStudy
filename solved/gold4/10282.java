import java.io.*;
import java.util.*;


public class Main{
	
	static class Graph{
		int end, sec;
		
		Graph(int end, int sec){
			this.end = end;
			this.sec = sec;
		}
	}
	
	static class Node implements Comparable<Node>{
		int next, totalSec;
		
		Node(int next, int totalSec){
			this.next = next;
			this.totalSec = totalSec;
		}

		@Override
		public int compareTo(Node o) {
			return this.totalSec - o.totalSec;
		}
	}
	
	static int[] line, dist;
	static int T, N, D, C;
	static ArrayList<Graph>[] Computers;
	static PriorityQueue<Node> pq;
	static final int INF = 1_000_000_000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			pq = new PriorityQueue<Node>();
			
			N = line[0];
			D = line[1];
			C = line[2];
			
			Computers = new ArrayList[N+1];
			dist = new int[N+1];
			
			for(int i = 0; i <= N; i++) {
				Computers[i] = new ArrayList<Graph>();
				dist[i] = INF;
			}
			
			for(int i = 0; i < D; i++) {
				line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				
				Computers[line[1]].add(new Graph(line[0], line[2]));
			}
			
			pq.add(new Node(C, 0));
			dist[C] = 0;
			
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				
				for(Graph g : Computers[n.next]) {
					int newTotal = n.totalSec + g.sec;
					
					if(dist[g.end] <= newTotal) continue;					

					dist[g.end] = newTotal;
					pq.add(new Node(g.end, newTotal));
				}
			}
			
			int max = 0;
			int cnt = 0;
			
			for(int i = 1; i <= N; i++) {
				if(dist[i] != INF) {
					cnt++;
					if(max < dist[i]) {
						max = dist[i];
					}
				}
			}
			sb.append(cnt).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
