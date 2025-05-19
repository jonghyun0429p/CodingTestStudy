import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NAndM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NAndM[0];
        M = NAndM[1];

        selected = new int[M];

        dfs(0,1);

    }

    public static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            selected[depth] = i;
            dfs(depth + 1, i); // 같은 수를 또 고를 수 있으므로 i 그대로 넘김
        }
    }
}
