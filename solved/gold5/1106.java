import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	//딱 봐도 DP로 푸는건데 어떻게 점화식을 걸어야하는 지 모르겠음;
	//가능한 예시가 N = 20개가 되는데, 정렬을 시켜두면 가성비 있게 들어가긴함;
	//첫번째로 가능할 때 까지하고, 남은 공간은 다음걸로, 남는 공간은 다음걸로 이런식?
	//

	static int C, N;
	static int[] dp;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a, b, answer;

        st = new StringTokenizer(br.readLine());
        
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[C+100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	a = Integer.parseInt(st.nextToken());
        	b = Integer.parseInt(st.nextToken());
        	
        	for(int j = b; j < C + 100; j++) {
        		if(dp[j-b] != Integer.MAX_VALUE){
        			dp[j] = Math.min(dp[j], a+dp[j-b]);
        		}
        	}
        }
        
        answer = Integer.MAX_VALUE;
        for(int i = C; i < C+100; i++) {
        	answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
        
    }
}
