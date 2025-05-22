import java.util.*;
import java.io.*;

public class Main {

	static String[] board;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = 10;

		for(int test_case = 1; test_case <= t; test_case++) {
			board = new String[16];
			visited = new boolean[16][16];

			int[] start = new int[2];
			int[] end = new int[2];

			int testNum = Integer.parseInt(br.readLine());

			for(int i = 0; i < 16; i++) {
				board[i] = br.readLine();
				for(int j = 0; j < 16; j++) {
					if(board[i].charAt(j) == '2') {
						start = new int[] {i, j};
					}else if(board[i].charAt(j) == '3'){
						end = new int[] {i, j};
					}
				}
			}

			if(BFS(start, end)) {
				System.out.printf("#%d %d\n", testNum, 1);
			}else {
				System.out.printf("#%d %d\n", testNum, 0);
			}
		}
	}

	static int[] dx = new int[] {1, -1, 0, 0};
	static int[] dy = new int[] {0, 0, 1, -1};

	public static boolean BFS(int[] start, int[] end) {
		Queue<int[]> que = new ArrayDeque<>();
		visited[start[0]][start[1]] = true;
		que.offer(start);

		while(!que.isEmpty()) {
			int[] curPoint = que.poll();
			visited[curPoint[0]][curPoint[1]] = true;

			for(int i = 0; i < 4; i++) {
				int nextX = curPoint[0] + dx[i];
				int nextY = curPoint[1] + dy[i];

				if(nextX < 0 || nextX >= 16 || nextY < 0 || nextY >= 16 || visited[nextX][nextY]) {
					continue;
				}

				int value = board[nextX].charAt(nextY) - '0';

				if(value == 3) {
					return true;
				}else if(value == 0) {
					visited[nextX][nextY] = true;
					que.offer(new int[] {nextX, nextY});
				}
			}
		}
		return false;
	}
}
