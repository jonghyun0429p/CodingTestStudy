import java.io.*;
import java.util.*;

public class arraymultiple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int sum;
        int maxSum;

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int maxLength = Math.max(N, M);
            int minLength = Math.min(M, N);
            maxSum = 0;

            for(int i = 0; i <= maxLength - minLength; i++) {
                sum = 0;
                for(int j = 0; j < minLength; j++) {
                    if(M == minLength) {
                        sum += A[i+j] * B[j];
                    }else {
                        sum += A[j] * B[i+j];
                    }
                }
                maxSum = Math.max(maxSum, sum);
            }
            System.out.printf("#%d %d\n", test_case, maxSum);
        }
    }
}
