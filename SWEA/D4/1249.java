import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	int x, y, cost;

	public Node(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

public class Main {
	public static void main(String[] args) throws IOException{
//		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			int size = Integer.parseInt(br.readLine());

			int[][] map = new int[size][size];

			for(int i = 0; i  < size; i++) {
				map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			}

			Daikstra(0, 0, map);

			System.out.printf("#%d %d\n", test_case, distance[size-1][size-1]);
		}
	}

	static int[][] distance;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};



	public static void Daikstra(int x, int y, int[][] map) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		distance = new int[map.length][map.length];
		for(int[] row : distance) {
			Arrays.fill(row,  Integer.MAX_VALUE);
		}
		distance[x][y] = map[x][y];
		que.offer(new Node(x, y, map[x][y]));

		while(!que.isEmpty()) {
			Node curNode = que.poll();
			int curX = curNode.x;
			int curY = curNode.y;
			int curCost = curNode.cost;

			if(curCost > distance[curX][curY]) {
				continue;
			}

			for(int d = 0; d < 4; d++) {
				int nextX = curX+dx[d];
				int nextY = curY+dy[d];

				if(nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map.length) {
					continue;
				}

				int newCost = curCost + map[nextX][nextY];
				if(newCost < distance[nextX][nextY]) {
					distance[nextX][nextY] = newCost;
					que.offer(new Node(nextX, nextY, newCost));
				}
			}
		}
	}
}


