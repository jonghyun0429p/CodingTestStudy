import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] countAndWeight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = countAndWeight[0];
        int weight = countAndWeight[1];
        int[] dp = new int[weight + 1];

        for(int i = 0; i < count; i++) {
        	int[] weightValue = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        	for (int k = weight; k >= weightValue[0]; k--) {
                dp[k] = Math.max(dp[k], dp[k - weightValue[0]] + weightValue[1]);
            }
        }

        System.out.println(dp[weight]);

    }
}