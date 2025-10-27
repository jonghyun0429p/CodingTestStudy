import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2, y2;
        int firstX = x1;
        int firstY = y1;
        int sum = 0;
        
        for(int i = 0; i < N-1; i++) {
        	st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            
            sum += Math.abs(x2-x1) + Math.abs(y2-y1);
            
            x1 = x2;
            y1 = y2;
            
            if(i == N-2) {
                sum += Math.abs(firstX-x1) + Math.abs(firstY-y1);            	
            }
        }
        
        
        System.out.println(sum);

    }
}
