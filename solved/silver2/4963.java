import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	//BFS
	//하루를 딱 정해서 돌아야하는데 bfs는 알아서 0일차부터 들어가서 상관없을듯.

	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int M,N;



	static void dfs(int x, int y) {
		visited[y][x] = true;
//		System.out.println(x+" "+y);
		for(int i = 0; i < 8; i++) {
			int curX = x + dx[i];
			int curY = y + dy[i];


			if(0 <= curX && 0 <= curY && curX < M && curY < N) {
//				System.out.println(curX+" "+curY);
				if(board[curY][curX] == 1 && !visited[curY][curX]) {
					dfs(curX, curY);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count;

		while(true) {
			st = new StringTokenizer(br.readLine());
			count = 0;

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			if(M == 0 && N == 0) {
				break;
			}

			board = new int[N][M];
			visited = new boolean[N][M];

			for(int i = 0; i < N; i++) {
				board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(board[i][j] == 1 && !visited[i][j]) {
						count += 1;
						dfs(j, i);
					}
				}
			}
			System.out.println(count);
		}
	}
}