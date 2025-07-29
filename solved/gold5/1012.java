package ct;

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

	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int answer = 0;

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			board = new int[M][N];
			visited = new boolean[M][N];

			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				board[x][y] = 1;
			}

			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(board[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}

	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[x][y] = true;
		q.add(new int[] {x,y});

		while(!q.isEmpty()) {
			int[] cur = q.poll();

			for(int i = 0; i < 4; i++) {
				int curX = dx[i] + cur[0];
				int curY = dy[i] + cur[1];

				if(0 <= curX && curX < board.length && 0 <= curY && curY < board[0].length) {
					if(board[curX][curY] == 1 && !visited[curX][curY]) {
						visited[curX][curY] = true;
						q.add(new int[] {curX, curY});
					}
				}
			}
		}

	}
}