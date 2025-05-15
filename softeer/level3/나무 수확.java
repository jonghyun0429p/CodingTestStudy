import java.io.*;
import java.util.*;

public class Main {

    static int[][] field;
    static int[][] dpFromStart;
    static int[][] dpToEnd;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        field = new int[n][n];
        dpFromStart = new int[n][n];
        dpToEnd = new int[n][n];

        for (int i = 0; i < n; i++) {
            field[i] = Arrays.stream(br.readLine().split(" "))
                             .mapToInt(Integer::parseInt)
                             .toArray();
        }

        // DP from (0,0) to (i,j)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = (j > 0) ? dpFromStart[i][j - 1] : 0;
                int up = (i > 0) ? dpFromStart[i - 1][j] : 0;
                dpFromStart[i][j] = Math.max(left, up) + field[i][j];
            }
        }

        // DP from (n-1,n-1) to (i,j) — 역방향
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int right = (j < n - 1) ? dpToEnd[i][j + 1] : 0;
                int down = (i < n - 1) ? dpToEnd[i + 1][j] : 0;
                dpToEnd[i][j] = Math.max(right, down) + field[i][j];
            }
        }

        // 스프링클러를 설치할 최적의 위치 찾기
        int maxTotal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // field[i][j]는 dpFromStart, dpToEnd 모두에 포함되므로 한번 빼주고, 두 배 적용
                int total = dpFromStart[i][j] + dpToEnd[i][j] - field[i][j] + field[i][j];
                maxTotal = Math.max(maxTotal, total);
            }
        }

        System.out.println(maxTotal);
    }
}