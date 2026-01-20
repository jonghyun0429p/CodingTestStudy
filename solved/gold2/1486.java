import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int x, y, time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    static int N, M, T, D;
    static int[][] board;
    static int[][] distGo, distBack;
    static final int INF = 1_000_000_000;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        distGo = new int[N][M];
        distBack = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                board[i][j] = (c <= 'Z') ? c - 'A' : c - 'a' + 26;
            }
        }

        dijkstra(distGo, false);
        dijkstra(distBack, true);

        int ans = board[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (distGo[i][j] + distBack[i][j] <= D) {
                    ans = Math.max(ans, board[i][j]);
                }
            }
        }

        System.out.println(ans);
    }

    static void dijkstra(int[][] dist, boolean reverse) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++)
            Arrays.fill(dist[i], INF);

        dist[0][0] = 0;
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.time > dist[cur.y][cur.x]) continue;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                int now = board[cur.y][cur.x];
                int next = board[ny][nx];

                // 역방향일 때 비용 계산 반전
                int diff = reverse ? now - next : next - now;
                if (Math.abs(diff) > T) continue;

                int cost = (diff <= 0) ? 1 : diff * diff;

                if (dist[ny][nx] > cur.time + cost) {
                    dist[ny][nx] = cur.time + cost;
                    pq.add(new Node(nx, ny, dist[ny][nx]));
                }
            }
        }
    }
}
