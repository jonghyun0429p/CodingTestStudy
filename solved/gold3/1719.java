import java.io.;
import java.util.;

public class Main {

    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node implements ComparableNode {
        int v, dist;
        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    static final int INF = 1_000_000_000;
    static int n, m;
    static ListEdge[] graph;
    static int[][] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i = n; i++) graph[i] = new ArrayList();

        for (int i = 0; i  m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        answer = new int[n + 1][n + 1];

        for (int s = 1; s = n; s++) {
            dijkstra(s);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i = n; i++) {
            for (int j = 1; j = n; j++) {
                if (i == j) sb.append(- );
                else sb.append(answer[i][j]).append( );
            }
            sb.append(n);
        }

        System.out.print(sb);
    }

    static void dijkstra(int start) {
        int[] dist = new int[n + 1];
        int[] first = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueueNode pq = new PriorityQueue();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.dist  dist[cur.v]) continue;

            for (Edge e  graph[cur.v]) {
                int next = e.to;
                int nd = cur.dist + e.cost;

                if (dist[next]  nd) {
                    dist[next] = nd;

                     핵심 로직
                    if (cur.v == start) first[next] = next;
                    else first[next] = first[cur.v];

                    pq.add(new Node(next, nd));
                }
            }
        }

        for (int i = 1; i = n; i++) {
            answer[start][i] = first[i];
        }
    }
}