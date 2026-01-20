import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long T = Long.parseLong(st.nextToken());

        long ans = 10 + 2 * (25 - A + T);
        if (ans < 0) ans = 0;

        System.out.println(ans);
    }
}
