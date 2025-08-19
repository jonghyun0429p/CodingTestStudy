import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, minValue, mask;
    static int[][] board;
    static HashSet<Integer> visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            minValue = Integer.MAX_VALUE;
            board = new int[N][N];
            visited = new HashSet<>();
            mask = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            backtracking(0, 0);
            System.out.println("#" + tc + " " + minValue);
        }
    }

    static void backtracking(int index, int choice) {
        if (choice == N / 2) {
            int fullMask = (1 << N) - 1;
            if (visited.contains(mask)) return;

            visited.add(mask);
            visited.add(fullMask ^ mask);
            getMinValue();
            return;
        }

        for (int i = index; i < N; i++) {
            mask |= (1 << i);
            backtracking(i + 1, choice + 1);
            mask ^= (1 << i);
        }
    }

    static void getMinValue() {
        int leftSum = 0;   // A음식
        int rightSum = 0;  // B음식

        // i<j로만 보며, 같은 그룹이면 (Sij + Sji) 합산
        for (int i = 0; i < N; i++) {
            boolean iInA = (mask & (1 << i)) != 0;
            for (int j = i + 1; j < N; j++) {
                boolean jInA = (mask & (1 << j)) != 0;

                if (iInA && jInA) {
                    leftSum += board[i][j] + board[j][i];
                } else if (!iInA && !jInA) {
                    rightSum += board[i][j] + board[j][i];
                }
            }
        }

        minValue = Math.min(minValue, Math.abs(leftSum - rightSum));
    }
}
