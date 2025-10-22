import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, A, B, C, result;
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        result = 0;
        if(A <= N) {
        	result += A;
        }else {
        	result += N;
        }
        
        if(B <= N) {
        	result += B;
        }else {
        	result += N;
        }
        
        if(C <= N) {
        	result += C;
        }else {
        	result += N;
        }
        
        System.out.println(result);
    }
}
