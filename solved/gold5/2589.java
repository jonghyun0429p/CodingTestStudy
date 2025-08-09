import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	//최단 시간이 가장 긴 두 곳을 찾아야함.
	//어짜피 시간만 있으면 되니까 각 L에서 각 L까지의 모든 최단 거리를 구하는게 맞을려나
	//최악은 모두 L이라면 50*49개의 선택지 2450개
	//bfs는 50*50 2500 시간 적용
	//2450*2500 약 5,000,000 가능은 함

	static int N, M;
	static char[][] board;
	static List<int[]> lList;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int result = 0;

		board = new char[N][M];
		lList = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				char c = line.charAt(j);
				if(c == 'L') {
					lList.add(new int[] {j, i});
				}
				board[i][j] = c;
			}
		}

		for(int i = 0; i < lList.size(); i++) {
			result = Math.max(result, bfs(lList.get(i)));
		}

		System.out.println(result);

	}

	static int bfs(int[] start) {
//		System.out.println(start[0]+" "+start[1]+" "+end[0]+ " "+ end[1]);
		visited = new boolean[N][M];
		int count = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {start[0], start[1], 0});
		visited[start[1]][start[0]] = true;

		while(!q.isEmpty()) {
			int[] cur = q.poll();

			for(int i = 0; i < 4; i++) {
				int curX = cur[0] + dx[i];
				int curY = cur[1] + dy[i];
				if(0 <= curX && 0 <= curY && curX < M && curY < N) {
					if(board[curY][curX] == 'L' && !visited[curY][curX]) {
						q.add(new int[] {curX, curY, cur[2]+1});
						visited[curY][curX] = true;
					}
				}
			}
			if(q.isEmpty()) {
				count = cur[2];
			}
		}
		return count;
	}
}