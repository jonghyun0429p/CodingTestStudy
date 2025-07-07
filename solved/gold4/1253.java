import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int N;

    public static boolean isGood(int targetIndex) {
        int target = arr[targetIndex];
        int left = 0;
        int right = N - 1;

        while (left < right) {
            if (left == targetIndex) {
                left++;
                continue;
            }
            if (right == targetIndex) {
                right--;
                continue;
            }

            int sum = arr[left] + arr[right];

            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (isGood(i)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
