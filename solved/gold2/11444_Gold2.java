import java.util.Scanner;

public class Main {

    static final int MOD = 1000000007;

    public static long[][] matMult(long[][] A, long[][] B) {
        return new long[][]{
            {
                (A[0][0] * B[0][0] + A[0][1] * B[1][0]) % MOD,
                (A[0][0] * B[0][1] + A[0][1] * B[1][1]) % MOD
            },
            {
                (A[1][0] * B[0][0] + A[1][1] * B[1][0]) % MOD,
                (A[1][0] * B[0][1] + A[1][1] * B[1][1]) % MOD
            }
        };
    }

    public static long[][] matPow(long[][] M, long power) {
        long[][] result = {{1, 0}, {0, 1}};  // 단위 행렬
        long[][] base = M;

        while (power > 0) {
            if (power % 2 == 1) {
                result = matMult(result, base);
            }
            base = matMult(base, base);
            power /= 2;
        }

        return result;
    }

    public static int fibonacci(long n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long[][] F = {{1, 1}, {1, 0}};
            long[][] resultMatrix = matPow(F, n - 1);
            return (int) resultMatrix[0][0];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        System.out.println(fibonacci(n));
    }
}
