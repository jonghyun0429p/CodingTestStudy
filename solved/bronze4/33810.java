import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String target = "SciComLove";

        int count = 0;
        for (int i = 0; i < target.length(); i++) {
            if (s.charAt(i) != target.charAt(i)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
