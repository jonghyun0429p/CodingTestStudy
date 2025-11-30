import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (((a + b) % 2 != 0) || ((a - b) % 2 != 0)) {
            System.out.println(-1);
            return;
        }

        int first = (a + b) / 2;
        int second = (a - b) / 2;

        if (first < 0 || second < 0) {
            System.out.println(-1);
            return;
        }

        if (first >= second) {
            System.out.println(first + " " + second);
        } else {
            System.out.println(second + " " + first);
        }
    }
}
