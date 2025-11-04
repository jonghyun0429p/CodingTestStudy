import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] list;
	static int N, M;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int start, end;
        
        N = Integer.parseInt(br.readLine());
        
        list = new int[N+1];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= N; i++) {
        	list[i] = Integer.parseInt(st.nextToken());
        }
        
        M = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	start = Integer.parseInt(st.nextToken());
        	end = Integer.parseInt(st.nextToken());
        	
        	if(start == end) {
        		sb.append(1).append("\n");
        	}else {
        		if(checkPel(start, end)) {
            		sb.append(1).append("\n");        			
        		}else {
            		sb.append(0).append("\n");
        		}
        	}     	
        }

    	System.out.println(sb.toString());   
    }
    
    public static boolean checkPel(int start, int end) {
    	boolean check = true;
    	
    	while(start < end) {
    		if(list[start] != list[end]) {
    			check = false;
    		}
    		start++;
    		end--;
    	}
    	
    	return check;
    }
}
