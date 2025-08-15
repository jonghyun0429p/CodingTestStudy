import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[] cards;
	static int[] leftCards = new int[9];
	static boolean[] visited = new boolean[9];
	static int[] result = new int[9];
	static int win, lose;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int index = 0;
			for(int i = 1; i <= 18; i++) {
				boolean has = false;
				for(int j = 0; j < 9; j++) {
					if(i == cards[j]) {
						has = true;
						break;
					}
				}
				if(!has) {
					leftCards[index] = i;
					index++;
				}
			}
			win = 0;
			lose = 0;

			dfs(0);
			sb.append("#"+test_case+" "+win+" "+lose+"\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int depth) {
		if(depth == 9) {
			if(isWin()) {
				win++;
			}else {
				lose++;
			}
		}

		for(int i = 0; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = leftCards[i];
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}

	static boolean isWin() {
		int in = 0;
		int gyu = 0;
		int sum;

		for(int i = 0; i < 9; i++) {
			sum = cards[i] + result[i];
			if(cards[i] < result[i]) {
				in += sum;
			}else if(cards[i] > result[i]) {
				gyu += sum;
			}
		}
		return gyu > in;
	}


}


