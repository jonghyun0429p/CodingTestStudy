import java.io.*;
import java.util.*;

public class Solution {

	static int[][] Things;
	static int T, N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());

        	Things = new int[N+1][2];

        	for(int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		Things[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        	}

        	int[] dp = new int[K+1];
        	int curK, curV;
        	for(int i = 0; i < N; i++) {
        		curK = Things[i][0];
        		curV = Things[i][1];
        		for(int j = K; j >= curK; j--) {
        			dp[j] = Math.max(dp[j], dp[j-curK] + curV);
        		}
        	}

        	System.out.println("#"+tc+" "+dp[K]);
        }
    }
}
