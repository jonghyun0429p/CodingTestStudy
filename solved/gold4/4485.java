import java.io.*;
import java.util.*;


// (0, 0)에서 출발해서 (n-1, n-1)
// (125, 125) 


public class Main {
	
	static class Node implements Comparable<Node>{
		int x, y, minus;
		
		Node(int x, int y, int minus){
			this.x = x;
			this.y = y;
			this.minus = minus;
		}

		@Override
		public int compareTo(Node o) {
			return this.minus - o.minus;
		}
	}

	static int N, cnt;
	static int[] list;
	static int[][] board;
	static int[][] dist;
	static PriorityQueue<Node> pq;
	static final int[] dx = {0, 1, 0, -1};
	static final int[] dy = {-1, 0, 1, 0};
	static final int INF = 1_000_000_000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		cnt = 0;
		
		while(true){
			N = Integer.parseInt(br.readLine());
			++cnt;
			
			if(N == 0) break;
			
			board = new int[N][N];
			dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				
				for(int j = 0; j < N; j++) {
					board[i][j] = list[j];
					dist[i][j] = INF;
				}
			}
			pq = new PriorityQueue<Node>();
			pq.add(new Node(0, 0, board[0][0]));
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				
				if(node.x == N-1 && node.y == N-1) {
					sb.append("Problem ").append(cnt).append(": ").append(node.minus).append("\n");
					break;
				}
				
				for(int d = 0; d < 4; d++) {
					int nx = node.x + dx[d];
					int ny = node.y + dy[d];
					
					if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1) continue;
					
					int sum = node.minus + board[ny][nx];
					
					if(dist[ny][nx] > sum) {
						dist[ny][nx] = sum;
						pq.add(new Node(nx, ny, sum));
					}
				}
			}			
		}
		System.out.println(sb.toString());
	}
}
