import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<Node>> graph = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            int[] node = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(node[0]).add(new Node(node[1], node[2]));
        }

        int[] startEnd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dist = dijkstra(N, startEnd[0], graph);

        System.out.println(dist[startEnd[1]]);
    }

    public static int[] dijkstra(int n, int start, List<List<Node>> graph) {
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(visited[node.to]) continue;
            visited[node.to] = true;

            for(Node neighbor : graph.get(node.to)) {
                if(dist[neighbor.to] > dist[node.to] + neighbor.weight) {
                    dist[neighbor.to] = dist[node.to] + neighbor.weight;
                    pq.add(new Node(neighbor.to, dist[neighbor.to]));
                }
            }
        }
        return dist;
    }
}
