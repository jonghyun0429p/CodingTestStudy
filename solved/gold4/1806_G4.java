import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] list;
	static int S, min, right, left, sum;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        list = new int[Integer.parseInt(st.nextToken())];
        S = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        right = 0;
        left = 0;
        sum = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < list.length; i++) {
        	list[i] = Integer.parseInt(st.nextToken());
        }
        
        while(right < list.length) {
        	sum += list[right];
        	
        	while(sum >= S) {
        		System.out.println(left+" "+right+" "+sum);
        		sum -= list[left];
        		min = Math.min(min, right-left+1);
        		left++;
        	}
        	
        	right++;
        }
        
        System.out.println(min);
        
    }
}
