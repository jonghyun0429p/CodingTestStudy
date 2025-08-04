import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	//DFS
	static int N;
	static int[][] ground;
	static boolean[][] visited;
	static int[] dx = {0, -1, 1, 0};
	static int[] dy = {-1, 0, 0, 1};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int maxGround = 0;
		N = Integer.parseInt(br.readLine());
		ground = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for(int j = 0; j < N; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i <= 100; i++) {
			visited = new boolean[N][N];
			maxGround = Math.max(maxGround, getGround(i));
		}

		System.out.println(maxGround);
	}

	static int getGround(int height) {
		int count = 0;

		 for(int i = 0; i < N; i++) {
			 for(int j = 0; j < N; j++) {
				 if(ground[i][j] > height && !visited[i][j]) {
					 count += 1;
					 bfs(j, i, height);
				 }
			 }
		 }

		 return count;
	}

	static void bfs(int x, int y, int height) {
		int curX, curY;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, y});
		visited[y][x] = true;

		while(!q.isEmpty()) {
			int[] cur = q.poll();

			for(int i = 0; i < 4; i++) {
				curX = cur[0] + dx[i];
				curY = cur[1] + dy[i];

				if(0 <= curX && 0 <= curY && curX < N && curY < N) {
					if(!visited[curY][curX] && ground[curY][curX] > height) {
						visited[curY][curX] = true;
						q.add(new int[] {curX, curY});
					}
				}
			}
		}
	}
}