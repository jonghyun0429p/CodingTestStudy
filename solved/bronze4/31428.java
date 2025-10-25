import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] list;

	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        list = new int[4];
        int answer = 0;
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	switch (st.nextToken()) {
            case "C":
                list[0]++;
                break;
            case "S":
                list[1]++;
                break;
            case "I":
                list[2]++;
                break;
            case "A":
                list[3]++;
                break;
        	}
        }
        
    	switch (br.readLine()) {
        case "C":
            answer = list[0];
            break;
        case "S":
            answer = list[1];
            break;
        case "I":
            answer = list[2];
            break;
        case "A":
            answer = list[3];
            break;
    	}
    	
    	System.out.println(answer);
    }
}
