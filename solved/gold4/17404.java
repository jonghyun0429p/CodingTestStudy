import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, answer, best;
	static int[][] DP, Cost;
	static final int INF = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        DP = new int[N][3];
        Cost = new int[N][3];
        best = Integer.MAX_VALUE;
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	Cost[i][0] = Integer.parseInt(st.nextToken());
        	Cost[i][1] = Integer.parseInt(st.nextToken());
        	Cost[i][2] = Integer.parseInt(st.nextToken());
        }
        
        for(int c = 0; c < 3; c++){
        	
        	DP[0][0] = INF;
        	DP[0][1] = INF;
        	DP[0][2] = INF;
        	answer = INF;
        	
	        switch(c) {
		        case 0:
		        	DP[0][0] = Cost[0][0];
		        	break;
		        case 1:
		        	DP[0][1] = Cost[0][1];
		        	break;
		        case 2:
		        	DP[0][2] = Cost[0][2];
		        	break;
	        }
	        
	        for(int i = 1; i < N; i++) {
	            DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2])+Cost[i][0];
	           	DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2])+Cost[i][1];
	           	DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1])+Cost[i][2];	
	        }
	        
	        for(int j = 0; j < 3; j++) {
	        	if(DP[0][j] == INF) {
	        		answer = Math.min(answer, DP[N-1][j]);
	        	}
	        }
	        
	        best = Math.min(best, answer);
        }
        
        System.out.println(best);
    }
}