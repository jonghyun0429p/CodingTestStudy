import java.io.*;
import java.util.*;

public class Solution {
    static final int N = 100;
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 0; tc < 10; tc++) {
            int tcNum = Integer.parseInt(br.readLine().trim());
            int sx = -1, sy = -1;
            char[][] map = new char[N][N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    char c = s.charAt(j);
                    map[i][j] = c;
                    if (c == '2') { sy = i; sx = j; }
                }
            }
            boolean[][] visited = new boolean[N][N];
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{sy, sx});
            visited[sy][sx] = true;
            int reachable = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                if (map[cur[0]][cur[1]] == '3') { reachable = 1; break; }
                for (int d = 0; d < 4; d++) {
                    int ny = cur[0] + dy[d];
                    int nx = cur[1] + dx[d];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                    if (visited[ny][nx]) continue;
                    char nxt = map[ny][nx];
                    if (nxt == '1') continue;
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
            System.out.println("#" + tcNum + " " + reachable);
        }
    }
}
