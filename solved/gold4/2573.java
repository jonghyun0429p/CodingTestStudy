import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	//DFS
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {0, -1, 1, 0};
	static int[] dy = {-1, 0, 0, 1};
	static int n, m;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		boolean notZero = true;
		int count = 0;
		int year = 0;

		for(int i = 0; i < n; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		while(true) {
		    visited = new boolean[n][m];
		    count = 0;

		    for(int i = 0; i < n; i++) {
		        for(int j = 0; j < m; j++) {
		            if(board[i][j] > 0 && !visited[i][j]) {
		                getIceLand(j, i);
		                count++;
		            }
		        }
		    }

		    if(count == 0) {
		        System.out.println(0);
		        return;
		    }

		    if(count >= 2) {
		        System.out.println(year);
		        return;
		    }

		    meltIce();
		    year++;
		}
	}
	static void getIceLand(int x, int y) {
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[]{x, y});
	    visited[y][x] = true; // 시작 지점 체크

	    while (!q.isEmpty()) {
	        int[] cur = q.poll();
	        for (int i = 0; i < 4; i++) {
	            int curX = cur[0] + dx[i];
	            int curY = cur[1] + dy[i];

	            if (0 <= curX && 0 <= curY && curX < m && curY < n) {
	                if (board[curY][curX] != 0 && !visited[curY][curX]) {
	                    visited[curY][curX] = true; // 중복 방지
	                    q.add(new int[]{curX, curY});
	                }
	            }
	        }
	    }
	}


	// 빙산이 동시에 녹도록 각 칸마다 줄어들 높이를 따로 저장
	static void meltIce() {
	    int[][] meltAmount = new int[n][m];

	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < m; j++) {
	            if(board[i][j] > 0) {
	                for(int d = 0; d < 4; d++) {
	                    int ni = i + dy[d];
	                    int nj = j + dx[d];
	                    if(0 <= ni && ni < n && 0 <= nj && nj < m && board[ni][nj] == 0) {
	                        meltAmount[i][j]++;
	                    }
	                }
	            }
	        }
	    }

	    // 한 번에 감소 적용
	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < m; j++) {
	            board[i][j] = Math.max(0, board[i][j] - meltAmount[i][j]);
	        }
	    }
	}

}