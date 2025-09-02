import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, M, C;
    static int[][] map;
    static int[][] best;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            best = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c <= N - M; c++) {
                    int[] arr = new int[M];
                    for (int k = 0; k < M; k++) arr[k] = map[r][c + k];
                    best[r][c] = getMaxProfit(arr);
                }
            }

            int ans = 0;
            for (int r1 = 0; r1 < N; r1++) {
                for (int c1 = 0; c1 <= N - M; c1++) {
                    for (int r2 = r1; r2 < N; r2++) {
                        for (int c2 = 0; c2 <= N - M; c2++) {
                            if (r1 == r2 && overlap(c1, c2)) continue;
                            ans = Math.max(ans, best[r1][c1] + best[r2][c2]);
                        }
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.print(sb.toString());
    }

    static int getMaxProfit(int[] arr) {
        int m = arr.length;
        int[] suffixSum = new int[m + 1];
        int[] suffixSq = new int[m + 1];
        for (int i = m - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i];
            suffixSq[i] = suffixSq[i + 1] + arr[i] * arr[i];
        }
        return dfs(arr, 0, 0, 0, suffixSum, suffixSq);
    }

    static int dfs(int[] arr, int idx, int sum, int score, int[] suffixSum, int[] suffixSq) {
        if (sum > C) return 0;
        if (idx == arr.length) return score;
        if (sum + suffixSum[idx] <= C) return score + suffixSq[idx];
        int best = 0;
        best = Math.max(best, dfs(arr, idx + 1, sum, score, suffixSum, suffixSq));
        if (sum + arr[idx] <= C) {
            best = Math.max(best, dfs(arr, idx + 1, sum + arr[idx], score + arr[idx] * arr[idx], suffixSum, suffixSq));
        }
        return best;
    }

    static boolean overlap(int c1, int c2) {
        return !(c1 + M - 1 < c2 || c2 + M - 1 < c1);
    }
}
