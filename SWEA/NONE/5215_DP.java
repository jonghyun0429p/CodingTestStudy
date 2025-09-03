import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[] taste = new int[N];
            int[] cal = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                cal[i]  = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[L + 1];
            for (int i = 0; i < N; i++) {
                int t = taste[i], k = cal[i];
                for (int c = L; c >= k; c--) {
                    dp[c] = Math.max(dp[c], dp[c - k] + t);
                }
            }

            out.append('#').append(tc).append(' ').append(dp[L]).append('\n');
        }
        System.out.print(out);
    }
}