import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();

        // 왼쪽 최대 구간합 계산
        int[] leftMax = new int[n];
        int sum = arr[0];
        int maxSum = arr[0];
        leftMax[0] = maxSum;

        for (int i = 1; i < n; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            maxSum = Math.max(maxSum, sum);
            leftMax[i] = maxSum;
        }

        // 오른쪽 최대 구간합 계산
        int[] rightMax = new int[n];
        sum = arr[n - 1];
        maxSum = arr[n - 1];
        rightMax[n - 1] = maxSum;

        for (int i = n - 2; i >= 0; i--) {
            sum = Math.max(arr[i], sum + arr[i]);
            maxSum = Math.max(maxSum, sum);
            rightMax[i] = maxSum;
        }

        // 두 구간이 적어도 한 칸 떨어지게 해야 함
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++) {
            answer = Math.max(answer, leftMax[i] + rightMax[i + 2]);
        }

        System.out.println(answer);
    }
}