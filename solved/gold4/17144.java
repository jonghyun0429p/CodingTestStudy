import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	//R, C, T 은 Row, Col, Time
	//공기청정기는 -1값

	static int R, C, T;
	static int[][] board;
	static int[][] tempBoard;
	static List<int[]> air;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		board = new int[R][C];
		air = new ArrayList<>();

		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				int now = Integer.parseInt(st.nextToken());
				board[i][j] = now;
				if(now == -1) {
					air.add(new int[] {j,i});
				}
			}
		}

		for(int time = 0; time < T; time++) {
			tempBoard = new int[R][C];

			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					tempBoard[i][j] = board[i][j];
				}
			}

			spreadDust();
			operateAir();
		}

		System.out.println(getDust());
	}

	static void spreadDust() {


		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(board[i][j] > 0) {
					int count = 0;
					int spreadValue = board[i][j]/5;

					for(int t = 0; t < 4; t++) {
						int curX = j + dx[t];
						int curY = i + dy[t];

						if(0 <= curX && 0 <= curY && curX < C && curY < R) {
							if(board[curY][curX] != -1) {
								tempBoard[curY][curX] += spreadValue;
								count += 1;
							}
						}
					}

					tempBoard[i][j] -= spreadValue * count;
				}
			}
		}

		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				board[i][j] = tempBoard[i][j];
			}
		}

	}

	static void operateAir() {
		int[] first = air.get(0);
		int[] second = air.get(1);

		boolean notFirst = false;
		int turn = 0;
		int x = first[0];
		int y = first[1];
		while(true) {
			if(board[y][x] == -1 && notFirst) {
				break;
			}
			notFirst = true;
			int nextX = x + dx[turn];
			int nextY = y + dy[turn];

			if(0 <= nextX && 0 <= nextY && nextX < C && nextY < R) {
				if(board[y][x] == -1) {
					tempBoard[nextY][nextX] = 0;
				}else if(board[nextY][nextX] != -1){
					tempBoard[nextY][nextX] = board[y][x];
				}
				x = nextX;
				y = nextY;
			}

			if(nextX == C - 1 && nextY == first[1]) {
				turn = 1;
			}else if(nextX == C - 1 && nextY == 0) {
				turn = 2;
			}else if(nextX == 0 && nextY == 0) {
				turn = 3;
			}else if(nextX == 0 && nextY == first[1]) {
				turn = 0;
			}

		}

		notFirst = false;
		turn = 0;
		x = second[0];
		y = second[1];
		while(true) {
			if(board[y][x] == -1 && notFirst) {
				break;
			}
			notFirst = true;
			int nextX = x + dx[turn];
			int nextY = y + dy[turn];

			if(0 <= nextX && 0 <= nextY && nextX < C && nextY < R) {
				if(board[y][x] == -1) {
					tempBoard[nextY][nextX] = 0;
				}else if(board[nextY][nextX] != -1){
					tempBoard[nextY][nextX] = board[y][x];
				}
				x = nextX;
				y = nextY;
			}

			if(nextX == C - 1 && nextY == second[1]) {
				turn = 3;
			}else if(nextX == C - 1 && nextY == R - 1) {
				turn = 2;
			}else if(nextX == 0 && nextY == R - 1) {
				turn = 1;
			}else if(nextX == 0 && nextY == second[1]) {
				turn = 0;
			}
		}

		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				board[i][j] = tempBoard[i][j];
			}
		}
	}

	static int getDust() {
		int result = 2;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				result += board[i][j];
			}
		}
		return result;
	}
}