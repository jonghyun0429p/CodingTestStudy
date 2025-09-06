import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, maxValue, minValue;
	static int[] nums, opers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
        	N = Integer.parseInt(br.readLine());
        	maxValue = Integer.MIN_VALUE;
        	minValue = Integer.MAX_VALUE;

        	opers = new int[4];
        	nums = new int[N];

        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i < 4; i++) {
        		opers[i] = Integer.parseInt(st.nextToken());
        	}

        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i < N; i++) {
        		nums[i] = Integer.parseInt(st.nextToken());
        	}

        	backtracking(1, nums[0]);

        	System.out.printf("#%d %d\n", test_case, maxValue-minValue);

        }
    }

    static void backtracking(int depth, int cur) {
    	if(depth == N) {
    		maxValue = Math.max(maxValue, cur);
    		minValue = Math.min(minValue, cur);
    		return;
    	}

    	int next = nums[depth];

    	for(int i = 0; i < 4; i++) {
    		if(opers[i] == 0) continue;
    		opers[i]--;
    		switch(i) {
    			case 0 : backtracking(depth+1, cur + next); break;
    			case 1 : backtracking(depth+1, cur - next); break;
    			case 2 : backtracking(depth+1, cur * next); break;
    			case 3 : backtracking(depth+1, cur / next); break;
    		}
    		opers[i]++;
    	}
    }
}