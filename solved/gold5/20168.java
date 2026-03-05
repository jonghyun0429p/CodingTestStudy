import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 1000000000;
    static int N, M, A, B, C;
    static ArrayList<Graph>[] Graphs;
    
    static class Graph {
        int next, cost;
        Graph(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
    
    static class Node implements Comparable<Node> {
        int idx, max, total;
        
        Node(int idx, int max, int total) {
            this.idx = idx;
            this.max = max;
            this.total = total;
        }

        @Override
        public int compareTo(Node o) {
            if (this.max != o.max) {
                return this.max - o.max;
            }
            return this.total - o.total;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Graphs = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            Graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Graphs[a].add(new Graph(b, c));
            Graphs[b].add(new Graph(a, c));
        }

        System.out.println(solve());
    }

    static int solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dist[A] = 0;
        pq.add(new Node(A, 0, 0));

        while (!pq.isEmpty()) {
            Node n = pq.poll();

            if (n.max > dist[n.idx]) continue;
            
            if (n.idx == B) return n.max;

            for (Graph g : Graphs[n.idx]) {
                int nextTotal = n.total + g.cost;
                int nextMax = Math.max(n.max, g.cost);

                if (nextTotal <= C) {
                    if (dist[g.next] > nextMax) {
                        dist[g.next] = nextMax;
                        pq.add(new Node(g.next, nextMax, nextTotal));
                    }
                }
            }
        }

        return -1;
    }
}