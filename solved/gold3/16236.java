import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
	static int[][] visited;
	static int[][] board;
	static int[] shark;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];


		for(int i = 0; i < N; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j = 0; j < N; j++) {
				if(board[i][j] == 9) {
					shark = new int[] {j, i};
				}
			}
		}

		System.out.println(countTime());
	}

	static int countTime() {
		int size = 2;
		int count = 0;
		int preMovingTime = -1;
		int movingTime = 0;

		while(preMovingTime != movingTime) {
			preMovingTime = movingTime;
			movingTime += getMovingTime(size);
			count += 1;

			if(size == count) {
				size += 1;
				count = 0;
			}
		}

		return movingTime;
	}

	static int getMovingTime(int size) {
		int movingTime = 0;
		int[] fish = getFish(size);
		System.out.println("먹이 " + fish[0]+","+fish[1]);
		System.out.println("상어 " + shark[0]+ ","+shark[1]);
		if(fish[0] != -1 && fish[1] != -1) {
			movingTime += getMove(int size);
			shark = fish;
		}
		System.out.println(movingTime);
		return movingTime;
	}

	static int[] getFish(int size) {
		int[] fish = new int[2];
		Arrays.fill(fish, -1);

		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(0 < board[i][j] && board[i][j] < size) {
					if(fish[0] == -1 && fish[1] == -1) {
						fish = new int[] {j, i};
					}else {
						int fishDist = Math.abs(fish[0] - shark[0]) + Math.abs(fish[1]-shark[1]);
						int newDist = Math.abs(i-shark[0]) + Math.abs(j-shark[1]);

						fish = fishDist > newDist ? new int[] {j, i} : fish;
					}
				}
			}
		}
		return fish;
	}

	static int getmove(int size) {
		Queue<int[]>
	}
}