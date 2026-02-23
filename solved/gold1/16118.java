import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    static int N, M;
    static List<Edge>[] adj;
    static int[] foxDist;
    static int[][] wolfDist;

    static class Edge implements Comparable<Edge> {
        int to, weight, state;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        Edge(int to, int weight, int state) {
            this.to = to;
            this.weight = weight;
            this.state = state;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            adj[u].add(new Edge(v, w * 2));
            adj[v].add(new Edge(u, w * 2));
        }

        solveFox();
        solveWolf();

        int result = 0;
        for (int i = 2; i <= N; i++) {
            if (foxDist[i] < Math.min(wolfDist[0][i], wolfDist[1][i])) {
                result++;
            }
        }
        System.out.println(result);
    }

    static void solveFox() {
        foxDist = new int[N + 1];
        Arrays.fill(foxDist, INF);
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        foxDist[1] = 0;
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (foxDist[curr.to] < curr.weight) continue;

            for (Edge next : adj[curr.to]) {
                if (foxDist[next.to] > foxDist[curr.to] + next.weight) {
                    foxDist[next.to] = foxDist[curr.to] + next.weight;
                    pq.add(new Edge(next.to, foxDist[next.to]));
                }
            }
        }
    }

    static void solveWolf() {
        wolfDist = new int[2][N + 1];
        Arrays.fill(wolfDist[0], INF);
        Arrays.fill(wolfDist[1], INF);
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        wolfDist[0][1] = 0;
        pq.add(new Edge(1, 0, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (wolfDist[curr.state][curr.to] < curr.weight) continue;

            for (Edge next : adj[curr.to]) {
                int nextState = 1 - curr.state;
                int cost = curr.weight;

                if (curr.state == 0) { 
                    cost += next.weight / 2;
                } else { 
                    cost += next.weight * 2;
                }

                if (wolfDist[nextState][next.to] > cost) {
                    wolfDist[nextState][next.to] = cost;
                    pq.add(new Edge(next.to, cost, nextState));
                }
            }
        }
    }
}