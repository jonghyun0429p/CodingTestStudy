import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        // 각 일의자리의 주기
        int[][] cycle = new int[10][];
        cycle[0] = new int[]{10};              // 0 -> 10번 컴퓨터
        cycle[1] = new int[]{1};
        cycle[2] = new int[]{2,4,8,6};
        cycle[3] = new int[]{3,9,7,1};
        cycle[4] = new int[]{4,6};
        cycle[5] = new int[]{5};
        cycle[6] = new int[]{6};
        cycle[7] = new int[]{7,9,3,1};
        cycle[8] = new int[]{8,4,2,6};
        cycle[9] = new int[]{9,1};

        for (int t = 0; t < T; t++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            int d = a % 10;
            int[] arr = cycle[d];

            int ans = (d == 0) ? 10 : arr[(b - 1) % arr.length];
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}
