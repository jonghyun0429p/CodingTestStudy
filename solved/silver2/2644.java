import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	//DFS

	static List<List<Integer>> graph;
	static boolean[] visited;
	static int n, m;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		graph = new ArrayList<>();

		for(int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		m = Integer.parseInt(br.readLine());

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph.get(x).add(y);
			graph.get(y).add(x);
		}

		System.out.println(getStep(start, end, 0));
	}

	static int getStep(int start, int end, int count) {
		if(start == end) {
			return count;
		}

		for(int i : graph.get(start)) {
			if(!visited[i]) {
				visited[i] = true;
	            int result = getStep(i, end, count + 1);
	            if (result != -1) return result;
			}

		}

		return -1;
	}
}