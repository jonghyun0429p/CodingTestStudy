import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        double edge = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == 'Y') {
                    edge += 0.5;              // 무방향 간선 중복 방지
                    graph[i].add(j);
                }
            }
        }

        // 간선 수 부족
        if (edge < n - 1) {
            System.out.println(-1);
            return;
        }

        // 고립 정점 체크 (n == 1 제외)
        if (n != 1) {
            for (int i = 0; i < n; i++) {
                if (graph[i].isEmpty()) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i);
            }
        }

        System.out.println(components - 1);
    }

    static void dfs(int cur) {
        visited[cur] = true;
        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
