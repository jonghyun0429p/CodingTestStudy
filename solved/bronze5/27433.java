import java.util.*;
import java.io.*;

public class Main{

	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int sum = 1;
		
		for(int i = N; i > 1; i--) {
			sum *= i;
		}
		
		System.out.println(sum);
	}
}