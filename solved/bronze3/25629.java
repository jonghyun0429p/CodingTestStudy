import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int oddCount = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x % 2 != 0) {
                oddCount++;
            }
        }

        int oddPositions = (N + 1) / 2;

        if (oddCount == oddPositions) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}