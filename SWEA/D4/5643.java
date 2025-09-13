import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            boolean[][] dist = new boolean[N + 1][N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                dist[a][b] = true;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (dist[i][k] && dist[k][j]) {
                            dist[i][j] = true;
                        }
                    }
                }
            }

            int rankableCount = 0;

            for (int i = 1; i <= N; i++) {
                int smallerCount = 0;
                int largerCount = 0;

                for (int j = 1; j <= N; j++) {
                    if (dist[i][j]) {
                        smallerCount++;
                    }
                    if (dist[j][i]) {
                        largerCount++;
                    }
                }

                if (smallerCount + largerCount == N - 1) {
                    rankableCount++;
                }
            }

            sb.append("#").append(t).append(" ").append(rankableCount).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}