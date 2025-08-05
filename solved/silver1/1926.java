import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];
		int count = 0;
		int size = 0;

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] == 1 && !visited[i][j]) {
					size = Math.max(size, bfs(j, i));
					count++;
				}
			}
		}
		System.out.println(count);
		System.out.println(size);
	}
	static int bfs(int x, int y) {
		int result = 1;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, y, result});
		visited[y][x] = true;

		while(!q.isEmpty()) {
			int[] cur = q.poll();

			for(int i = 0; i < 4; i++) {
				int curX = cur[0] + dx[i];
				int curY = cur[1] + dy[i];

				if(0 <= curX && 0 <= curY && curX < M && curY < N) {
					if(board[curY][curX] == 1 && !visited[curY][curX]) {
						result += 1;
						q.add(new int[] {curX, curY, result});
						visited[curY][curX] = true;
					}
				}
			}
		}
		return result;
	}
}
