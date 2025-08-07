import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int F, S, G, U, D;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		visited = new boolean[F+1];

		if (S == G) {
		    System.out.println(0);
		    return;
		}
		if (U == 0 && D == 0) {
		    System.out.println("use the stairs");
		    return;
		}

		int result = bfs(S);

		if(result == -1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(result);
		}
	}

	static int bfs(int start) {
		int count = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start, 0});
		visited[start] = true;

		while(!q.isEmpty()) {
			int[] cur = q.poll();
			count = cur[1];

			if(cur[0] == G) {
				return count;
			}

			int curUp = cur[0]+U;
			int curDown = cur[0]-D;

			if(curUp <= F && !visited[curUp]) {
				q.add(new int[] {curUp, cur[1]+1});
				visited[curUp] = true;
			}
			if(0 <= curDown && !visited[curDown]) {
				q.add(new int[] {curDown, cur[1]+1});
				visited[curDown] = true;
			}
		}
		return -1;
	}
}