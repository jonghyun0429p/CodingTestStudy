import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T, N;
	static int[] array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			array = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				array[i] = Integer.parseInt(st.nextToken());				
			}
			
			int[] dp = new int[N];
			
			for(int i = 0; i < N; i++) {
				
				dp[i] = 1;
				
				for(int j = 0; j < i; j++) {
					if(array[i] > array[j] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
			}
			
			int answer = 0;
			for (int i = 0; i < N; i++) {
			    answer = Math.max(answer, dp[i]);
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
