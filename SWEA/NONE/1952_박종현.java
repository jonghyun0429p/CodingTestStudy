import java.io.*;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class Solution {

    static int T, day, month, thmonth, year;
    static int[] plans, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            thmonth = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());
            
            plans = new int[13];
            dp = new int[13];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= 12; i++) {
            	plans[i] = Integer.parseInt(st.nextToken());
            }
            
            int max;
            
            for(int i = 1; i <= 12; i++) {
            	max = dp[i-1] + Math.min(day*plans[i], month);
            	
            	if(i%12 == 0) {
            		max = Math.min(year, max);
            	}
            	if(i > 2) {
            		max = Math.min(max, dp[i-3]+thmonth);
            	}
            	
            	dp[i] = max;
            	
            }

            System.out.println("#" + tc + " " + dp[12]);
        }
    }
}
