import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N, R;
	static final int P = 1234567891;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            
            long nFac = factorial(N);
            long rFac = factorial(R);
            long nrFac = factorial(N-R);
            long denom = (rFac * nrFac) % P;
            
            long mod = (nFac*modInverse(denom)) % P;
            
            sb.append("#").append(t).append(" ").append(mod).append("\n");
            
        }
        System.out.println(sb.toString());
    }
    
    static long factorial(int n) {
    	long result = 1;
    	for(int i = 1; i <= n; i++) {
    		result = (result*i) % P;
    	}
    	return result;
    }
    
    static long modInverse(long a) {
    	return power(a, P-2);
    }
    
    static long power(long a, int b) {
    	long result = 1;
    	
    	while(b > 0) {
    		if(b % 2 == 1) {
    			result = (result*a) % P;
    		}
    		a = (a * a) % P;
    		b /= 2;
    	}
    	return result;
    }
}
