import java.io.*;
import java.util.*;

public class Solution {
    static int T, N, count;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }
            bfs();
            System.out.println("#"+tc+" "+count);
        }
    }
    static void bfs(){
        int[] cur;
        int curX, curY;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        q.add(new int[] {0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()){
            cur = q.poll();

            if(cur[0] == N-1 && cur[1] == N-1) count = cur[2];

            for(int i = 0; i < 4; i++){
                curX = cur[0] + dx[i];
                curY = cur[1] + dy[i];

                if(0 <= curX && 0 <= curY && curX < N && curY < N){
                    if(!visited[curY][curX]){
                        visited[curY][curX] = true;
                        q.add(new int[] {curX, curY, cur[2]+board[curY][curX]});
                    }
                }
            }
        }

    }
}
