import java.io.*;
import java.util.*;

public class Main {

	public static long modula(long a, long b, long c) {

		if(b == 0) {
			return 1;
		}

		long half = modula(a, b/2, c);
		long result = (half * half) % c;

		if(b % 2 == 1) {
			result = (result*a) % c ;
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] ABC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		System.out.println(modula(ABC[0], ABC[1], ABC[2]));

    }
}