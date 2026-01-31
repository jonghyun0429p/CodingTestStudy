import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 20000303;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int result = 0;

        for (int i = 0; i < N.length(); i++) {
            int digit = N.charAt(i) - '0';
            result = (result * 10 + digit) % MOD;
        }

        System.out.println(result);
    }
}
