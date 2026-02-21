import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            br.readLine(); // 빈 줄 처리

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int maxS = 0;
            int maxB = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                maxS = Math.max(maxS, Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                maxB = Math.max(maxB, Integer.parseInt(st.nextToken()));
            }

            if (maxS >= maxB) sb.append("S\n");
            else sb.append("B\n");
        }

        System.out.print(sb);
    }
}