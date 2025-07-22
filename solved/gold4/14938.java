import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//
public class Main {
	static int maxDist;
	static int[] items;
	static List<Node>[] nodes;

	static class Node{
		int to;
		int dist;

		Node(int to, int dist){
			this.to = to;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NMR = br.readLine().split(" ");
		int N = Integer.parseInt(NMR[0]);
		maxDist = Integer.parseInt(NMR[1]);
		int R = Integer.parseInt(NMR[2]);
		int result = 0;

		//초기화 및 할당
		nodes = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		items = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		//길 데이터 입력
		for(int i = 0; i < R; i++) {
			String[] ABL = br.readLine().split(" ");
			int A = Integer.parseInt(ABL[0]);
			int B = Integer.parseInt(ABL[1]);
			int L = Integer.parseInt(ABL[2]);

			nodes[A].add(new Node(B, L));
			nodes[B].add(new Node(A, L));
		}

		for(int i = 0; i < N; i++) {
			result = Math.max(result, dijk(i));
		}

		System.out.println(result);

	}

	static int dijk(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
		int sum = 0;
		int[] dist = new int[nodes.length];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		pq.offer(new Node(start, 0));

		while(!pq.isEmpty()) {
			Node cur = pq.poll();

			//가려는 곳에 도달 할 수 있는 거리보다 지금 가려고 하는 길이 더 길다면 의미가 없으니 제외하는 것.
			if(dist[cur.to] < cur.dist) {
				continue;
			}

			//다음 가능한 노드들을 가져오고, 다음 값의 목표 거리가 지금 거리 + 다음 길 거리 보다 큰 지 비교하고 큐에 넣음
			for(Node next : nodes[cur.to]) {
				int newDist = dist[cur.to]+ next.dist;
				if(dist[next.to] > newDist) {
						dist[next.to] = newDist;
						pq.offer(new Node(next.to, newDist));
				}
			}
		}

		for(int i = 1; i < dist.length; i++) {
			if(dist[i] <= maxDist) {
				sum += items[i-1];
			}
		}

		return sum;
	}
}