import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
 
	static int T, N, M;
	static char[][] board;
	static boolean[][] visited;
	static int[] soo, prin;
	static Queue<int[]> devils;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());    
            M = Integer.parseInt(st.nextToken());
           board = new char[N][M];
           visited = new boolean[N][M];
           devils = new ArrayDeque<>();
           
           for(int i = 0; i < N; i++) {
        	   String[] line = br.readLine().split("");
        	   
        	   for(int j = 0; j < M; j++) {
        		   if(line[j].equals("S")) {
        			   soo = new int[] {j, i};
        			   visited[i][j] = true;
        		   }else if(line[j].equals("D")) {
        			   prin = new int[] {j, i};
        		   }else if(line[j].equals("*")) {
        			   devils.add(new int[] {j, i});
        		   }
        		   board[i][j] = line[j].charAt(0);
        	   }
           }
           int result = move();
           
           if(result == -1) {
        	   System.out.println("#"+tc+" "+"GAME OVER");
           }else {
        	   System.out.println("#"+tc+" "+result);
           }
        }
    }
    
    static int move() {
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[2]));
        q.add(new int[] {soo[0], soo[1], 0});
        int prev = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            // (B) 현재 위치가 악마에게 먹혔으면 더 확장 못 함
            if (board[cur[1]][cur[0]] == '*') continue;

            if (cur[0] == prin[0] && cur[1] == prin[1]) {
                return cur[2];
            }

            if (prev != cur[2]) {
                prev = cur[2];
                devilSpread();
            }

            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if (x < 0 || y < 0 || x >= M || y >= N) continue;
                if (visited[y][x]) continue;

                if (board[y][x] == 'D') {            // 이동으로 D면 즉시 성공(선호)
                    return cur[2] + 1;
                }
                if (board[y][x] == '.') {
                    visited[y][x] = true;
                    q.add(new int[] {x, y, cur[2] + 1});
                }
            }
        }
        return -1;
    }

    static void devilSpread() {
        int size = devils.size();
        for (int i = 0; i < size; i++) {
            int[] devil = devils.poll();

            for (int j = 0; j < 4; j++) {
                int x = devil[0] + dx[j];
                int y = devil[1] + dy[j];

                if (x < 0 || y < 0 || x >= M || y >= N) continue;

                // (A) '.' 또는 'S'로 확장. D, X는 제외
                if (board[y][x] == '.' || board[y][x] == 'S') {
                    board[y][x] = '*';
                    devils.add(new int[] {x, y});
                }
            }
        }
    }

}