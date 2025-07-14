import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 수열 크기
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[] dpUp = new int[N];     // 증가하는 부분 수열 길이
        int[] dpDown = new int[N];   // 감소하는 부분 수열 길이

        // 증가 부분 수열 (왼쪽에서 오른쪽으로)
        for (int i = 0; i < N; i++) {
            dpUp[i] = 1;  // 자기 자신 포함
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dpUp[i] = Math.max(dpUp[i], dpUp[j] + 1);
                }
            }
        }

        // 감소 부분 수열 (오른쪽에서 왼쪽으로)
        for (int i = N - 1; i >= 0; i--) {
            dpDown[i] = 1;  // 자기 자신 포함
            for (int j = N - 1; j > i; j--) {
                if (A[j] < A[i]) {
                    dpDown[i] = Math.max(dpDown[i], dpDown[j] + 1);
                }
            }
        }

        // 가장 긴 바이토닉 수열 계산
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            int length = dpUp[i] + dpDown[i] - 1;
            maxLength = Math.max(maxLength, length);
        }

        System.out.println(maxLength);
    }
}