import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] board;
    static boolean[] visitedAlpha;  // A~Z 방문 여부
    static int max = 0;

    // 상하좌우
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visitedAlpha = new boolean[26];  // A~Z

        // 시작점
        visitedAlpha[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }

    static void dfs(int x, int y, int count) {
        // 최대 칸 수 갱신
        max = Math.max(max, count);

        // 상하좌우 이동
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위 체크
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

            // 방문 안 한 알파벳이면 이동
            int alphaIndex = board[nx][ny] - 'A';
            if (!visitedAlpha[alphaIndex]) {
                visitedAlpha[alphaIndex] = true;
                dfs(nx, ny, count + 1);
                visitedAlpha[alphaIndex] = false;  // 백트래킹
            }
        }
    }
}
