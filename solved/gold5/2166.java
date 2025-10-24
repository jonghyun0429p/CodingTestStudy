import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static long[][] pointList;
	static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sum = 0;
        
        int N = Integer.parseInt(br.readLine());
        pointList = new long[N][2];
        
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	pointList[i][0] = Long.parseLong(st.nextToken());
        	pointList[i][1] = Long.parseLong(st.nextToken());
        }
        
        for(int i = 0; i < N; i++) {
        	sum += pointList[i][0] * pointList[(i+1)%N][1] - pointList[(i+1)%N][0] * pointList[i][1];
        }
        System.out.println(String.format("%.1f", Math.abs(sum)/2.0));
    }
}
