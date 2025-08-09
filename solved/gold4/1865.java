import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	//N개 지점 M개 도로 W개 웜홀 도착하면 시간이 뒤로감
	//출발해서 다시 출발한 위치로 돌아왔을 때, 시간을 돌아가는 경우가 있는지 없는지 궁금해졌다.
	//첫 줄 테스트 케이스 수
	//두번째 줄부터 M+1줄까지 도로의 정보
	//M+2번째 줄부터 M+W+1번째 줄까지 웜홀의 정보
	//거리를 구하는 알고리즘 사용하기. 다익스트라 또는 벨만 포드
	//웜홀은 다르게 구해버리면서 다익스트라(V^2)를 쓰는지 그냥 벨만 포드(VE)로 다 구할지, 벨만 포드가 나을듯
	//모든 길을 노드로 사용해서 구하면 VE(정점*간선) 최악 정점 500 간선 2500+200 = 150,000,000 약 1500만 가능

	static class Edge{
		int from;
		int to;
		int weight;

		Edge(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	static List<Edge>[] edges;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= TC; test_case++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			dist = new int[N+1];
			edges = new ArrayList[N+1];

			Arrays.fill(dist, Integer.MAX_VALUE);

			for(int i = 0; i <= N; i++) {
				edges[i] = new ArrayList<>();
			}

			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());

				edges[S].add(new Edge(S, E, T));
				edges[E].add(new Edge(E, S, T));
			}

			for(int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());

				edges[S].add(new Edge(S, E, -T));
			}

			for (int i = 1; i <= N; i++) {
			    edges[0].add(new Edge(0, i, 0));
			}

			if (bellmanFord(N)) {
			    System.out.println("YES");
			} else {
			    System.out.println("NO");
			}
		}
	}

	static boolean bellmanFord(int N) {
	    for (int i = 1; i <= N; i++) {
	        for (int u = 0; u <= N; u++) {
	            if (edges[u] == null) continue;
	            for (Edge edge : edges[u]) {
	                int from = edge.from;
	                int to = edge.to;
	                int weight = edge.weight;

	                if (dist[from] != Integer.MAX_VALUE &&
	                    dist[to] > dist[from] + weight) {
	                    dist[to] = dist[from] + weight;

	                    if (i == N) {
	                        return true;  // 음의 사이클 존재
	                    }
	                }
	            }
	        }
	    }
	    return false;
	}
}