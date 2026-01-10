import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	
	static class Road implements Comparable<Road>{
		int curX, curY, cnt;

		public Road(int curX, int curY, int cnt) {
			this.curX = curX;
			this.curY = curY;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Road o) {
			return this.cnt - o.cnt;
		}
	}
	
	static int row, col;
	static int[][] board;
	static PriorityQueue<Road> pq;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		row = size[0];
		col = size[1];
		
		board = new int[col][row];
		visited = new boolean[col][row];
		
		for(int i = 0; i < col; i++) {
			size = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			
			for(int j = 0; j < row; j++) {
				board[i][j] = size[j];
			}
		}
		
		pq = new PriorityQueue<Road>();
		pq.add(new Road(0, 0, 0));
		visited[0][0] = true;
		Road r;
		
		while(!pq.isEmpty()) {
			r = pq.poll();
			
			if(r.curX == row-1 && r.curY == col-1) {
				System.out.println(r.cnt);
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = r.curX + dx[i];
				int ny = r.curY + dy[i];
				
				if(nx < 0 || ny < 0 || row <= nx || col <= ny) continue;
				if(visited[ny][nx] == false) {
					pq.add(new Road(nx, ny, r.cnt + board[ny][nx]));
					visited[ny][nx] = true;
//					System.out.println("지금 위치 "+ nx + " " + ny + " 부순 횟수 " + (r.cnt + board[ny][nx]));
				}
			}
		}
	}
}
