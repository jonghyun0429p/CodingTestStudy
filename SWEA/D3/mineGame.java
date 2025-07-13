package ct;

import java.io.*;
import java.util.*;

public class mineGame {

    public static String[] inputs;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            int size = Integer.parseInt(br.readLine());
            inputs = new String[size];
            board = new int[size][size];
            visited = new boolean[size][size];
            int clickCount = 0;

            // 입력받기
            for(int i = 0; i < size; i++) {
                inputs[i] = br.readLine();
            }

            // 숫자로 된 정보로 변환
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    board[i][j] = getMineInfo(i, j);
                }
            }

            // 0인 값들을 눌러서 확인 (연쇄적으로 처리)
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(board[i][j] == 0 && !visited[i][j]) {
                        bfs(i, j, size);  // BFS로 연쇄적으로 처리
                        clickCount += 1;  // 한번 클릭으로 모든 0이 연쇄적으로 처리됨
                    }
                }
            }

            // 나머지 값들을 눌러서 확인 (1 이상인 값들만)
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(board[i][j] < 9 && !visited[i][j]) {
                        visited[i][j] = true;
                        clickCount += 1;
                    }
                }
            }

            System.out.printf("#%d %d\n", test_case, clickCount);
        }
    }

    // 주어진 칸 주변의 지뢰 개수 세기
    public static int getMineInfo(int x, int y) {
        if(inputs[y].charAt(x) == '*') {
            return 9;  // 지뢰는 9로 표시
        }

        int sum = 0;

        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < inputs.length && 0 <= ny && ny < inputs.length) {
                if(inputs[ny].charAt(nx) == '*') {
                    sum += 1;
                }
            }
        }

        return sum;
    }

    // 0인 칸을 클릭하여 연쇄적으로 표시하는 함수 (BFS)
    public static void bfs(int row, int col, int size) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int curRow = current[0];
            int curCol = current[1];

            for(int i = 0; i < 8; i++) {
                int nextRow = curRow + dx[i];
                int nextCol = curCol + dy[i];

                if(0 <= nextRow && nextRow < size && 0 <= nextCol && nextCol < size) {
                    // 0인 칸을 발견하면 연쇄적으로 클릭
                    if(board[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        q.offer(new int[] {nextRow, nextCol});
                    }
                    // 1 이상인 칸은 클릭만 하고 연쇄적 확장은 없음
                    if(board[nextRow][nextCol] < 9 && !visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
    }
}