import java.io.*;
import java.util.*;

public class Main {

	public static int bfs(int start, int end) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {start, 0});

		while(!que.isEmpty()) {
			int[] current_que = que.poll();
			int current_num = current_que[0];
			int count = current_que[1];
			String numString = current_num + "1";
			int plusOne = Integer.parseInt(numString);

			if(current_que[0] == end) {
				return count + 1;
			}

			if(current_num * 2 <= end) {
				que.offer(new int[] {current_num * 2, count + 1});
			}

			if(plusOne <= end) {
				que.offer(new int[] {plusOne, count + 1});
			}
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] AB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int A = AB[0];
		int B = AB[1];

		System.out.println(bfs(A, B));
    }
}