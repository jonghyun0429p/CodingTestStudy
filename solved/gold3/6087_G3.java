import java.io.*;
import java.util.*;


public class Main{
	
	static class Lazer{
		int x, y;
		
		Lazer(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static class State implements Comparable<State>{
		int x, y, dir, cost;
		
		State(int x, int y, int dir, int cost){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}

		@Override
		public int compareTo(State o) {
			return this.cost - o.cost;
		}
	}
	
	static int W, H;
	static Lazer l1, l2;
	static int[] line;
	static int[][][] dist;
	static char[][] board;
	static String str;
	static PriorityQueue<State> pq;
	static final int INF = 1_000_000_000;
	static final int[] dx = {0, 1, 0, -1};
	static final int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		W = line[0];
		H = line[1];
		dist = new int[H][W][4];
		
		board = new char[H][W];
		
		for(int i = 0; i < H; i++) {
			str = br.readLine();
			for(int j = 0; j < W; j++) {
				board[i][j] = str.charAt(j);
				if(str.charAt(j) == 'C') {
					if(l1 == null) {
						l1 = new Lazer(j, i);
					}else {
						l2 = new Lazer(j, i);
					}
				}
				for(int d = 0; d < 4; d++) {
					dist[i][j][d] = INF;
				}
			}
		}
		
		pq = new PriorityQueue<>();
		for(int i = 0; i < 4; i++) {
			dist[l1.y][l1.x][i] = 0;
			pq.add(new State(l1.x, l1.y, i, 0));
		}
		
		while(!pq.isEmpty()) {
			State s = pq.poll();
			
			if(s.x == l2.x && s.y == l2.y) {
				sb.append(s.cost);
				break;
			}
			
			if(s.cost > dist[s.y][s.x][s.dir]) continue;
			
			for(int d = 0; d < 4; d++) {
				int nx = s.x + dx[d];
				int ny = s.y + dy[d];
				
				if(nx < 0 || ny < 0 || W <= nx || H <= ny) continue;
				if(board[ny][nx] == '*') continue;
				
				int newCost = s.cost;
				
				if(s.dir != d) {
					newCost += 1;
				}
				
				if(dist[ny][nx][d] > newCost) {
					dist[ny][nx][d] = newCost;
					pq.add(new State(nx, ny, d, newCost));
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
