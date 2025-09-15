import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, M, maxValue;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            maxValue = 0;

            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int k = 1; k <= N + 1; k++) {
                getMaxCost(k);
            }

            sb.append("#").append(t).append(" ").append(maxValue).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void getMaxCost(int size) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxValue = Math.max(maxValue, getCost(j, i, size));
            }
        }
    }

    static int getCost(int x, int y, int size) {
        Queue<int[]> q = new ArrayDeque<>();
        int nextX, nextY, count, home;
        int[] cur;

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        count = -(size * size + (size - 1) * (size - 1));

        home = 0;
        q.add(new int[]{x, y});
        visited[y][x] = true;
        if(map[y][x] == 1) {
            count += M;
            home++;
        }
        while (!q.isEmpty()) {
            cur = q.poll();

            for (int i = 0; i < 4; i++) {
                nextX = cur[0] + dx[i];
                nextY = cur[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;

                if (!visited[nextY][nextX] && Math.abs(nextX - x) + Math.abs(nextY - y) <= size-1) {
                    visited[nextY][nextX] = true;
                    if (map[nextY][nextX] == 1) {
                        count += M;
                        home++;
                    }
                    q.add(new int[]{nextX, nextY});
                }
            }
        }
        return count >= 0 ? home : 0;
    }
}