import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, maxValue, room;
    static int[][] board;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            maxValue = 0;
            room = 0;

            board = new int[N][N];
            visited = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(visited[i][j] == 0){
                        dfs(j, i, board[i][j]);
                        if(maxValue < visited[i][j]){
                            maxValue = visited[i][j];
                            room = board[i][j];
                        }else if(maxValue == visited[i][j]){
                            if(room > board[i][j]) room = board[i][j];
                        }
                    }
                }
            }
            System.out.printf("#%d %d %d\n", tc, room, maxValue);
        }
    }

    static void dfs(int x, int y, int value){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int curX = x + dx[i];
            int curY = y + dy[i];

            if(0 <= curX && 0 <= curY && curX < N && curY < N){
                if(value == board[curY][curX] - 1){
                    if(visited[curY][curX] == 0){
                        dfs(curX, curY, board[curY][curX]);
                    }
                    visited[y][x] = visited[curY][curX] + 1;
                    break;
                }
//
            }
        }
    }
}
