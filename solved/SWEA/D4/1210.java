import java.util.*;
import java.io.*;

public class Main {

	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;

		for (int test_case = 0; test_case < T; test_case++) {
			int caseNum = Integer.parseInt(br.readLine());

			board = new int[100][100];
			for (int i = 0; i < 100; i++) {
				board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			List<Integer> startPoints = new ArrayList<>();

			for (int i = 0; i < 100; i++) {
				if (board[0][i] == 1) {
					startPoints.add(i);
				}
			}

			for (int start : startPoints) {
				if (DFS(start, 0)) {
					System.out.printf("#%d %d\n", caseNum, start);
					break;
				}
			}
		}
	}

	public static boolean DFS(int startX, int startY) {
		if (board[startY][startX] == 2) {
			return true;
		}

		if (startY == 99) {
			return false;
		}

		int right = startX + 1;
		int left = startX - 1;
		int down = startY + 1;

		// 오른쪽으로 이동
		if (right < 100 && board[startY][right] == 1) {
			while (right < 100 && board[startY][right] == 1) {
				startX = right;
				right++;
			}
			return DFS(startX, down);
		}

		// 왼쪽으로 이동
		else if (left >= 0 && board[startY][left] == 1) {
			while (left >= 0 && board[startY][left] == 1) {
				startX = left;
				left--;
			}
			return DFS(startX, down);
		}

		// 아래로 이동
		else {
			return DFS(startX, down);
		}
	}
}
