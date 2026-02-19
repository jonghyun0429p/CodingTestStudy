import java.io.*;
import java.util.*;

public class Main {

    static int count;

    public static int recursion(String s, int l, int r) {
        count++;  // 호출될 때마다 카운트

        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l + 1, r - 1);
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            count = 0;

            int result = isPalindrome(s);

            sb.append(result).append(" ").append(count).append("\n");
        }

        System.out.print(sb);
    }
}