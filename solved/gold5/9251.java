//LCS DP문제

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        int firstLength = first.length();
        int secondLength = second.length();

        int[][] dp = new int[firstLength+1][secondLength+1];

        for(int i = 1; i <= firstLength; i++){
            for(int j = 1; j <= secondLength; j++){
                if(first.charAt(i-1) == second.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[firstLength][secondLength]);
    }
}
