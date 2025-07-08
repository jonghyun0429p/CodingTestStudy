import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 입력 받기 (행렬의 크기 N과 거듭제곱 B)
        String[] NAndB = br.readLine().split("\\s+");
        int N = Integer.parseInt(NAndB[0]); // 행렬의 크기 N
        long B = Long.parseLong(NAndB[1]);  // 거듭제곱 B (Long 타입으로 처리)

        int[][] matrix = new int[N][N];

        // 행렬 A 입력 받기
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("\\s+");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        // 단위 행렬로 초기화
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            result[i][i] = 1;
        }

        // 행렬 A의 B제곱을 구하기
        int[][] answer = matPow(matrix, B, N);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    // 행렬 A를 B번 거듭제곱하는 함수
    public static int[][] matPow(int[][] matrix, long B, int N) {
        int[][] result = new int[N][N];
        // 단위 행렬로 초기화
        for (int i = 0; i < N; i++) {
            result[i][i] = 1;
        }

        int[][] base = matrix;

        while (B > 0) {
            if (B % 2 == 1) {
                result = matMult(result, base, N);  // 홀수일 때는 결과에 base 곱하기
            }
            base = matMult(base, base, N);  // base를 제곱
            B /= 2;
        }

        return result;
    }

    // 두 행렬을 곱하는 함수 (모듈러 연산 포함)
    public static int[][] matMult(int[][] A, int[][] B, int N) {
        int[][] C = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % 1000;  // 모듈러 연산
                }
            }
        }

        return C;
    }
}