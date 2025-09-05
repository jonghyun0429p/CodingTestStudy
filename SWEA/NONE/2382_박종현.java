import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static class Micro {
        int count, way, best;
        Micro(int count, int way) {
            this.count = count;
            this.way = way;
            this.best = count;
        }
    }

    static int T, N, M, K, result;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, -1, 1, 0, 0};
    static Micro[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            result = 0;

            grid = new Micro[N][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                int way = Integer.parseInt(st.nextToken());

                if (grid[y][x] == null) {
                    grid[y][x] = new Micro(count, way);
                } else {
                    grid[y][x].count += count;
                }
            }

            for (int i = 0; i < M; i++) {
                Micro[][] newGrid = new Micro[N][N];

                for (int y = 0; y < N; y++) {
                    for (int x = 0; x < N; x++) {
                        if (grid[y][x] != null) {
                            Micro micro = grid[y][x];
                            int newY = y + dy[micro.way];
                            int newX = x + dx[micro.way];

                            if (newY == 0 || newX == 0 || newY == N - 1 || newX == N - 1) {
                                micro.count /= 2;
                                if (micro.count == 0) continue;
                                if (micro.way == 1) micro.way = 2;
                                else if (micro.way == 2) micro.way = 1;
                                else if (micro.way == 3) micro.way = 4;
                                else if (micro.way == 4) micro.way = 3;
                            }

                            if (newGrid[newY][newX] == null) {
                                newGrid[newY][newX] = new Micro(micro.count, micro.way);
                            } else {
                                newGrid[newY][newX].count += micro.count;
                                if (newGrid[newY][newX].best < micro.count) {
                                    newGrid[newY][newX].best = micro.count;
                                    newGrid[newY][newX].way = micro.way;
                                }
                            }
                        }
                    }
                }

                grid = newGrid;
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (grid[y][x] != null) {
                        result += grid[y][x].count;
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}