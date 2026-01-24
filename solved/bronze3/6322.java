import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;

            sb.append("Triangle #").append(tc++).append("\n");

            if (a == -1) {
                double val = c * c - b * b;
                if (val <= 0) sb.append("Impossible.\n");
                else sb.append(String.format("a = %.3f\n", Math.sqrt(val)));
            }
            else if (b == -1) {
                double val = c * c - a * a;
                if (val <= 0) sb.append("Impossible.\n");
                else sb.append(String.format("b = %.3f\n", Math.sqrt(val)));
            }
            else {
                sb.append(String.format("c = %.3f\n", Math.sqrt(a * a + b * b)));
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
