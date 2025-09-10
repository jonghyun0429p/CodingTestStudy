import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T, N, MIN;
	static int[][] array;
	static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	
        	array = new int[N][N];
        	
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < N; j++) {
        			array[i][j] = Integer.parseInt(st.nextToken());
        			if(i != j && array[i][j] == 0) {
        				array[i][j] = INF;
        			}
        		}
        	}
        	
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < N; j++) {
        			for(int k = 0; k < N; k++) {
        				array[i][j] = Math.min(array[i][j], array[i][k] + array[k][j]);
        			}
        		}
        	}
        	
        	MIN = INF;
        	int count;
        	for(int i = 0; i < N; i++) {
        		count = 0;
        		for(int j = 0; j < N; j++) {
        			count += array[i][j];
        		}
        		MIN = Math.min(MIN, count);
        	}
        	System.out.println("#"+t+" "+MIN);
        }
    }
}
