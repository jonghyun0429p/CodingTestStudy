import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int N, M;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NM[0];
        M = NM[1];

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxSum = Math.max(maxSum, getTetromino(i, j));
            }
        }

        System.out.println(maxSum);
    }

    public static int getTetromino(int i, int j) {
        int maxSum = 0;

        int[][][] tetrominos = {
                // I
                {{0,0},{0,1},{0,2},{0,3}},
                {{0,0},{1,0},{2,0},{3,0}},

                // O
                {{0,0},{0,1},{1,0},{1,1}},

                // L, J (8개)
                {{0,0},{1,0},{2,0},{2,1}},
                {{0,0},{0,1},{0,2},{1,0}},
                {{0,0},{0,1},{1,1},{2,1}},
                {{0,2},{1,0},{1,1},{1,2}},
                {{0,0},{1,0},{1,1},{1,2}},
                {{0,0},{1,0},{2,0},{0,1}},
                {{0,0},{0,1},{0,2},{1,2}},
                {{0,1},{1,1},{2,1},{2,0}},

                // S, Z (4개)
                {{0,0},{0,1},{1,1},{1,2}},
                {{0,1},{1,0},{1,1},{2,0}},
                {{0,1},{0,2},{1,0},{1,1}},
                {{0,0},{1,0},{1,1},{2,1}},

                // T (4개)
                {{0,0},{0,1},{0,2},{1,1}},
                {{0,1},{1,0},{1,1},{2,1}},
                {{0,1},{1,0},{1,1},{1,2}},
                {{0,0},{1,0},{1,1},{2,0}}
        };

        for (int[][] shape : tetrominos) {
            int sum = 0;
            boolean valid = true;
            for (int[] block : shape) {
                int x = i + block[0];
                int y = j + block[1];

                if (x < 0 || x >= N || y < 0 || y >= M) {
                    valid = false;
                    break;
                }

                sum += board[x][y];
            }

            if (valid) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
