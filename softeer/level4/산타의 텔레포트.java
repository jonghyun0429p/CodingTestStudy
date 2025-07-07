import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int n, m;
    static int[][] grid;
    static Map<Integer, List<int[]>> teleMap = new HashMap<>();
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        int giftX = -1, giftY = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int v = Integer.parseInt(st.nextToken());
                grid[i][j] = v;
                if (v == -2) {
                    giftX = i;
                    giftY = j;
                }
                if (v >= 10) {
                    teleMap.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }

        int d1 = bfs(0, 0, giftX, giftY);
        if (d1 == INF) {
            System.out.println(-1);
            return;
        }
        int d2 = bfs(giftX, giftY, n - 1, m - 1);
        System.out.println(d2 == INF ? -1 : d1 + d2);
    }

    // 0-1 BFS: 시작(sx,sy)에서 목표(tx,ty)까지 최소 텔레포트 횟수 반환
    static int bfs(int sx, int sy, int tx, int ty) {
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);
        boolean[] used = new boolean[100001];
        Deque<int[]> dq = new ArrayDeque<>();

        dist[sx][sy] = 0;
        dq.addFirst(new int[]{sx, sy});

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0], y = cur[1], d = dist[x][y];
            if (x == tx && y == ty) return d;

            // 상하좌우(비용 0)
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (grid[nx][ny] == -1) continue;
                if (dist[nx][ny] > d) {
                    dist[nx][ny] = d;
                    dq.addFirst(new int[]{nx, ny});
                }
            }
            // 텔레포트(비용 1)
            int v = grid[x][y];
            if (v >= 10 && !used[v]) {
                List<int[]> list = teleMap.get(v);
                if (list != null) {
                    for (int[] p : list) {
                        int i = p[0], j = p[1];
                        if (i == x && j == y) continue;
                        if (dist[i][j] > d + 1) {
                            dist[i][j] = d + 1;
                            dq.addLast(new int[]{i, j});
                        }
                    }
                }
                used[v] = true;
            }
        }
        return INF;
    }
}
