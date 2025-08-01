
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	//bfs
	//궁금한게 0,2 ~ 4,4 라면
	static int M, N, K;
	static boolean[][] board;
	static boolean[][] visited;
	static int[] dx = {0, -1, 1, 0};
	static int[] dy = {-1, 0, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		List<Integer> sizes = new ArrayList<>();

		board = new boolean[M][N];
		visited = new boolean[M][N];

		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for(int k = y1; k < y2; k++) {
				for(int j = x1; j < x2; j++) {
					board[k][j] = true;
				}
			}
		}

		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == false && !visited[i][j]) {
					sizes.add(bfs(j, i));
				}
			}
		}
		Collections.sort(sizes);
		System.out.println(sizes.size());
		for(int i : sizes) {
			System.out.print(i+" ");
		}
	}

	static int bfs(int x, int y) {
		int result = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, y});
		visited[y][x] = true;

		while(!q.isEmpty()) {
			result += 1;
			int[] cur = q.poll();

			for(int i = 0; i < 4; i++) {
				int curX = cur[0] + dx[i];
				int curY = cur[1] + dy[i];

				if(0 <= curX && 0 <= curY && curX < N && curY < M) {
					if(!visited[curY][curX] && board[curY][curX] == false) {
						q.add(new int[] {curX, curY});
						visited[curY][curX] = true;
					}
				}
			}
		}

		return result;
	}
}