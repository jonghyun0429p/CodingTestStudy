import java.io.*;
import java.util.*;

public class Solution {


    //8*8 좌표에 각각 5개까지 깊이를 뺸다고 하면, 8*8*5이니까 320을 bfs돌린다면 8*8 8*8*8*8*5 = 20480

    static int[][] mountains;
    static boolean[][] visited;
    static int T, N, K, maxHeight, maxLength;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            maxHeight = 0;
            maxLength = 0;
            int cur;
            mountains = new int[N][N];
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    cur = Integer.parseInt(st.nextToken());
                    mountains[i][j] = cur;
                    if(cur > maxHeight) {
                        maxHeight = cur;
                    }
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(maxHeight == mountains[i][j]) {
                        dfs(j, i, true, 1);
                    }
                }
            }

            System.out.println("#"+tc+" "+maxLength);
        }
    }

    static void dfs(int x, int y, boolean canCut, int cnt) {
        visited[y][x] = true;
        maxLength = Math.max(maxLength, cnt);

        int curH = mountains[y][x];

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visited[ny][nx]) continue;

            int nextH = mountains[ny][nx];


            if (nextH < curH) {
                dfs(nx, ny, canCut, cnt + 1);
            }

            else if (canCut) {

                int need = nextH - (curH - 1);
                if (need <= K) {
                    int backup = nextH;
                    mountains[ny][nx] = curH - 1;
                    dfs(nx, ny, false, cnt + 1);
                    mountains[ny][nx] = backup;
                }
            }
        }

        visited[y][x] = false;
    }

}