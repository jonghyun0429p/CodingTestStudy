import java.util.*;
import java.io.*;

public class Main {

	static int[][] board;
	static int[][] dp;

	public static void main(String[] args) throws IOException{
//		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		board = new int[size][size];

		for(int i = 0; i < size; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		dp = new int[size][size];
		for(int[] row : dp) {
			Arrays.fill(row, 0);
		}

		//dp - bottom-up
		dp[size-1] = board[size-1];

		for(int i = size-2; i >= 0; i--) {
			for(int j = 0; j <= i; j++) {
				dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + board[i][j];
			}
		}
		System.out.println(dp[0][0]);
	}
}