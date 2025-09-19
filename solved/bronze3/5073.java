import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0 && C == 0) break; // 종료 조건

            int max = Math.max(A, Math.max(B, C));
            int sum = A + B + C;

            // 삼각형 조건 체크
            if (sum - max <= max) {
                System.out.println("Invalid");
            } else if (A == B && B == C) {
                System.out.println("Equilateral");
            } else if (A == B || B == C || C == A) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}
