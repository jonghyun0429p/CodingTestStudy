import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Graph implements Comparable<Graph> {
        int to, weight;

        Graph(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Graph o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int N, M;
    static ArrayList<ArrayList<Graph>> graphList;
    static int[] dist;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int start, end, weight;

        graphList = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graphList.add(new ArrayList<>());
        }
        dist = new int[N + 1];
        prev = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            graphList.get(start).add(new Graph(end, weight));
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        getAnswer(start, end);
    }

    public static void getAnswer(int start, int end) {
        PriorityQueue<Graph> pq = new PriorityQueue<>();
        Arrays.fill(prev, -1); // 초기화
        dist[start] = 0;

        pq.add(new Graph(start, 0));

        while (!pq.isEmpty()) {
            Graph curG = pq.poll();

            if (curG.weight > dist[curG.to]) continue;

            for (Graph g : graphList.get(curG.to)) {
                // 경로 갱신이 필요할 경우
                if (dist[curG.to] + g.weight < dist[g.to]) {
                    dist[g.to] = dist[curG.to] + g.weight;
                    prev[g.to] = curG.to;
                    pq.add(new Graph(g.to, dist[g.to]));
                }
            }
        }

        if (dist[end] == Integer.MAX_VALUE) {
            System.out.println(-1); // 도달할 수 없는 경우 처리
            return;
        }

        ArrayList<Integer> con = new ArrayList<>();
        int pre = end;
        while (pre != -1) {
            con.add(pre);
            pre = prev[pre];
        }

        System.out.println(dist[end]);
        System.out.println(con.size());
        for (int i = con.size() - 1; i >= 0; i--) {
            System.out.print(con.get(i) + " ");
        }
    }
}
