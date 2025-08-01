import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static boolean[][][] visited; // [y][x][벽 부쉈는지 여부]
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M][2]; // 벽 부순 여부 0 or 1

        for(int i = 0; i < N; i++){
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(bfs());
    }

    static int bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1, 0}); // x, y, 이동거리, 벽 부쉈는지 여부(0이면 안 부심)
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            int broken = cur[3];

            if(x == M-1 && y == N-1){
                return dist;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <= nx && 0 <= ny && nx < M && ny < N){
                    // 벽이고 아직 안 부쉈으면 부수고 간다
                    if(board[ny][nx] == 1 && broken == 0 && !visited[ny][nx][1]){
                        visited[ny][nx][1] = true;
                        q.add(new int[]{nx, ny, dist + 1, 1});
                    }
                    // 벽이 아니고, 현재 상태(broken)에 맞게 아직 방문 안 했으면 이동
                    else if(board[ny][nx] == 0 && !visited[ny][nx][broken]){
                        visited[ny][nx][broken] = true;
                        q.add(new int[]{nx, ny, dist + 1, broken});
                    }
                }
            }
        }
        return -1;
    }
}
