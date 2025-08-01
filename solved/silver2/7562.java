import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	//bfs
	//궁금한게 0,2 ~ 4,4 라면
	static int size;
	static boolean[][] visited;
	static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= t; test_case++) {
			size = Integer.parseInt(br.readLine());
			visited = new boolean[size][size];

			int[] knight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] move = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			System.out.println(bfs(knight, move, 0));
		}
	}

	static int bfs(int[] knight, int[] move, int turn) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {knight[0], knight[1], turn});
		visited[knight[1]][knight[0]] = true;


		while(!q.isEmpty()) {
			int[] cur = q.poll();

			if(cur[0] == move[0] && cur[1] == move[1]) {
				return cur[2];
			}

			for(int i = 0; i < 8; i++) {
				int curX = cur[0] + dx[i];
				int curY = cur[1] + dy[i];

				if(0 <= curX && 0 <= curY && curX < size && curY < size) {
					if(!visited[curY][curX]) {
						visited[curY][curX] = true;
						q.add(new int[] {curX, curY, cur[2]+1});
					}
				}
			}
		}
		return -1;
	}
}