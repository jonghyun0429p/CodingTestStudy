import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        String cur;
        
        while(st.hasMoreTokens()) {
        	cur = st.nextToken();
        	if(cur.charAt(0) != '-' && cur.charAt(0) != '0') {
        		count++;
        	}
        }
        
        System.out.println(count);

    }
}
