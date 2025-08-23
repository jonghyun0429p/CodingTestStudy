import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, sum;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	board = new int[N][N];
        	sum = 0;
        	int space = N/2;

        	for(int i = 0; i < N; i++) {
        		String[] line = br.readLine().split("");
        		for(int j = 0; j < N; j++) {
        			board[i][j] = Integer.parseInt(line[j]);
        		}
        	}

        	for(int i = 0; i < N; i++) {
        		int size = Math.abs(space-i);
        		for(int j = size; j < N - size ; j++) {
        			sum += board[i][j];
        		}
        	}

        	System.out.printf("#%d %d\n", tc, sum);

        }
    }
}
