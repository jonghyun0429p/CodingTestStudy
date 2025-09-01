import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int T, H, W, N, status, nextX, nextY;
	static char[][] board;
	static String line;
	static int[] tank;
	static char[] tanks = {'^', 'v', '<', '>'};
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
        	status = 0;
        	st = new StringTokenizer(br.readLine());
        	H = Integer.parseInt(st.nextToken());
        	W = Integer.parseInt(st.nextToken());

        	board = new char[H][W];

        	for(int i = 0; i < H; i++) {
        		line = br.readLine();
        		for(int j = 0; j < W; j++) {
        			char cur = line.charAt(j);
        			board[i][j] = cur;
        			if(cur == '>') {
        				tank = new int[] {j, i};
        				status = 3;
        			}else if(cur == 'v') {
        				tank = new int[] {j, i};
        				status = 1;
        			}else if(cur == '<') {
        				tank = new int[] {j, i};
        				status = 2;
        			}else if(cur == '^') {
        				tank = new int[] {j, i};
        				status = 0;
        			}
        		}
        	}

        	N = Integer.parseInt(br.readLine());
        	line = br.readLine();

        	for(int i = 0; i < N; i++) {
        		inputData(line.charAt(i));
        	}

        	System.out.print("#" + tc + " ");
        	for(char[] j: board) {
        		for(char k : j) {
        			System.out.print(k);
        		}
        		System.out.println();
        	}
        }
    }

    static void inputData(char input) {
    	if(input == 'U') {
    		status = 0;
    		nextX = tank[0] + dx[status];
    		nextY = tank[1] + dy[status];
    	}else if(input == 'D') {
    		status = 1;
    		nextX = tank[0] + dx[status];
    		nextY = tank[1] + dy[status];
    	}else if(input == 'L') {
    		status = 2;
    		nextX = tank[0] + dx[status];
    		nextY = tank[1] + dy[status];
    	}else if(input == 'R') {
    		status = 3;
    		nextX = tank[0] + dx[status];
    		nextY = tank[1] + dy[status];
    	}else if(input == 'S') {
    		shooting();
    		return;
    	}

		board[tank[1]][tank[0]] = tanks[status];

    	if(0 > nextX || 0 > nextY || nextX >= W || nextY >= H) {
    		return;
    	}else if(board[nextY][nextX] == '#') {
    		return;
    	}

		if(board[nextY][nextX] == '.') {
			board[tank[1]][tank[0]] = '.';
			board[nextY][nextX] = tanks[status];
			tank = new int[] {nextX, nextY};
		}
    }

    static void shooting() {

    	boolean isAlive = true;
    	nextX = tank[0];
    	nextY = tank[1];
    	while(isAlive) {
    		nextX += dx[status];
    		nextY += dy[status];
    		if(0 <= nextX && 0 <= nextY && nextX < W && nextY < H) {
    			if(board[nextY][nextX] == '*') {
    				board[nextY][nextX] = '.';
    				isAlive = false;
    			}else if(board[nextY][nextX] == '#') {
    				isAlive = false;
    			}
    		}else {
    			isAlive = false;
    		}
    	}
    }
}
