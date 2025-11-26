import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[][] DP;
	public static int N, Cur, Idx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        DP = new int[N][2];
        
        DP[0][0] = Integer.parseInt(st.nextToken());
        DP[0][1] = 1;
        
        for(int i = 1 ; i < N; i++) {
        	Cur = Integer.parseInt(st.nextToken());
        	
        	if(DP[i-1][0] < Cur) {
        		DP[i][0] = Cur;
        		DP[i][1] = DP[i-1][1] + 1;
        	}else if(DP[i-1][0] == Cur) {
        		DP[i][0] = DP[i-1][0];
        		DP[i][1] = DP[i-1][1];
        	}else {
        		Idx = getIdx(i, Cur);
        		
        		DP[i][0] = DP[Idx][0];
        		DP[i][1] = DP[Idx][1]+1;
        	}
        }
        
        System.out.println(DP[N-1][1]);
    }
    
    public static int getIdx(int idx, int cur) {
    	int left = 0;
    	int right = idx;
    	int mid = (left+right)/2;
    	
    	
    	while(left < right) {    		
        	if(DP[mid][0] < cur) {
        		left = mid+1;
        	}else if(DP[mid][0] > cur) {
        		right = mid-1;
        	}else {
        		while(mid < idx) {
        			if(DP[mid][0] == DP[mid+1][0]) {
        				mid++;
        			}else{
        				mid++;
        				break;
        			}
        		}
        		break;
        	}
        	mid = (left+right)/2;
    	}
    	
    	return mid;
    }
}
