import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // x 좌표 (사용하지 않음)
            long y = Long.parseLong(st.nextToken());

            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
        }

        System.out.println(maxY - minY);
    }
}
