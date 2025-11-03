import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        double d;
        
        N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	d = Double.parseDouble(br.readLine())*(0.8);   
            System.out.printf("$%.2f\n", d);     	
        }
        
    }
}
