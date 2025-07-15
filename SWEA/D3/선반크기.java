import java.io.*;
import java.util.*;

public class Solution {

	static int[] heights;
    static int N, B;
    static int closest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
        	int[] NAndB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	N = NAndB[0];
        	B = NAndB[1];

        	int match = 0;
        	closest = Integer.MAX_VALUE;
        	heights = new int[N];

        	heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


            backtrack(0, 0);

            System.out.printf("#%d %d\n", test_case, closest - B);
        }
    }

    // 부분 집합을 탐색하는 백트래킹
    static void backtrack(int index, int sum) {
        if (sum >= B) {
            closest = Math.min(closest, sum);
            // 가지치기: 이미 최소로 가능한 합보다 커지면 종료
            return;
        }
        if (index == N) return;

        // heights[index] 포함
        backtrack(index + 1, sum + heights[index]);

        // heights[index] 미포함
        backtrack(index + 1, sum);
    }
}