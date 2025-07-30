import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	//BFS
	//하루를 딱 정해서 돌아야하는데 bfs는 알아서 0일차부터 들어가서 상관없을듯.

	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};



	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		int result = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 1) {
					visited[i][j] = true;
					q.add(new int[] {j, i, 0});
				}
			}
		}
		if(q.isEmpty()) {
			return -1;
		}

		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int curX = cur[0] + dx[i];
				int curY = cur[1] + dy[i];
				result = cur[2];

				if(0 <= curX && 0 <= curY && curX < board[0].length && curY < board.length) {
					if(board[curY][curX] == 0 && !visited[curY][curX]) {
						visited[curY][curX] = true;
						board[curY][curX] = 1;
						q.add(new int[] {curX, curY, cur[2]+1});
					}
				}
			}
		}

		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 0) {
					return -1;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		visited = new boolean[N][M];

		for(int i = 0; i < N; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		System.out.println(bfs());
	}
}