import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int homeCount = Integer.parseInt(br.readLine());
		int INF = 1000*homeCount;

		int[][] dp = new int[homeCount][3];

		for(int i = 0; i < homeCount; i++) {
			int[] homeColor = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			if(i == 0) {
				dp[0][0] = homeColor[0];
				dp[0][1] = homeColor[1];
				dp[0][2] = homeColor[2];
			}else {
				for(int j = 0; j < 3; j++) {
					if(j == 0) {
						dp[i][0] = homeColor[0] + Math.min(dp[i-1][1], dp[i-1][2]);
					}else if(j == 1) {
						dp[i][1] = homeColor[1] + Math.min(dp[i-1][0], dp[i-1][2]);
					}else {
						dp[i][2] = homeColor[2] + Math.min(dp[i-1][1], dp[i-1][0]);
					}
				}
			}
		}

		System.out.println(Math.min(dp[homeCount-1][0], Math.min(dp[homeCount-1][1], dp[homeCount-1][2])));

    }
}
