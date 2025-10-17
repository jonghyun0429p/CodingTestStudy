import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	static int size = 2;
	static int N, time, count;
	static int[] shark;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        time = 0;
        count = 0;
        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        
        int now;
        
        for(int i = 0; i < N; i++) {
        	String[] line = br.readLine().split(" ");
        	for(int j = 0; j < N; j++) {
        		now = Integer.parseInt(line[j]);        		
        		if(now == 9) {
        			shark = new int[] {j, i};
        		}else {
            		board[i][j] = now;        			
        		}
        	}
        }
        
        boolean canEat = true;
        
        while(canEat == true) {
    		visited = new boolean[N][N];
        	canEat = bfs();
        }
        
        System.out.println(time);
    }
    
    static boolean bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited = new boolean[N][N];

        q.offer(new int[]{shark[0], shark[1], 0});
        visited[shark[1]][shark[0]] = true;

        int minDist = Integer.MAX_VALUE;
        int targetX = -1, targetY = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], d = cur[2];

            if (d > minDist) break;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nd = d + 1;

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[ny][nx]) continue;

                if (board[ny][nx] > size) continue;

                visited[ny][nx] = true;

                if (board[ny][nx] > 0 && board[ny][nx] < size) {
                    if (nd < minDist) {
                        minDist = nd;
                        targetX = nx; targetY = ny;
                    } else if (nd == minDist) {
                        if (ny < targetY || (ny == targetY && nx < targetX)) {
                            targetX = nx; targetY = ny;
                        }
                    }
                }
                if (nd <= minDist) {
                    q.offer(new int[]{nx, ny, nd});
                }
            }
        }

        if (minDist == Integer.MAX_VALUE) {
            return false;
        }

        time += minDist;
        shark = new int[]{targetX, targetY};
        board[targetY][targetX] = 0;
        count++;
        if (count == size) {
            size++;
            count = 0;
        }
        return true;
    }

}