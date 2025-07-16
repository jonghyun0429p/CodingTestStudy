import java.io.*;
import java.util.*;

public class Solution {

	//사이클을 돌리면서 가능하고 불가능하고를 판단해야하는데, 시작점이 가능한 부분에서 이동 혹은 대기가 가능하다.
	//bfs를 돌려서 완성하면 시작하면 될듯.
	//bfs 최악은 약 4만번.

	static int[][] pool;
	static boolean[][][] visited;
	static int[] dx = {0, 1, 0, -1, 0};
	static int[] dy = {-1, 0, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
        	int N = Integer.parseInt(br.readLine());
        	pool = new int[N][N];
        	visited = new boolean[N][N][3];

        	for(int i = 0; i < N; i++) {
        		pool[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	}

        	int[] startPoint = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	int[] endPoint = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        	int time = bfs(startPoint, endPoint);

        	System.out.printf("#%d %d\n", test_case, time);
        }
    }

    static int bfs(int[] startPoint, int[] endPoint) {
        int N = pool.length;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startPoint[1], startPoint[0], 0}); // x, y, 시간
        visited[startPoint[0]][startPoint[1]][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];

            if (y == endPoint[0] && x == endPoint[1]) {
                return time;
            }

            for (int i = 0; i < 5; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nextTime = time + 1;
                int modTime = nextTime % 3;

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // 제자리 대기
                if (nx == x && ny == y) {
                    if (!visited[ny][nx][modTime]) {
                        visited[ny][nx][modTime] = true;
                        q.add(new int[]{nx, ny, nextTime});
                    }
                    continue;
                }

                if (visited[ny][nx][modTime]) continue;

                if (pool[ny][nx] == 0 || (pool[ny][nx] == 2 && time % 3 == 2)) {
                    visited[ny][nx][modTime] = true;
                    q.add(new int[]{nx, ny, nextTime});
                }
            }
        }

        return -1;
    }


}