import java.util.*;

public class Main {

    // 다익스트라 알고리즘 (최단 거리 계산)
    public static int[] dijkstra(int n, List<List<int[]>> graph, int start) {
        int[] distances = new int[n + 1];  // 1-based index
        Arrays.fill(distances, Integer.MAX_VALUE);  // 무한대 초기화
        distances[start] = 0;

        // 우선순위 큐 (거리, 노드 번호)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start});  // (거리, 노드 번호)

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDist = current[0];
            int currentNode = current[1];

            // 이미 더 짧은 경로가 있으면 건너뛰기
            if (currentDist > distances[currentNode]) {
                continue;
            }

            // 인접한 노드들을 확인
            for (int[] neighbor : graph.get(currentNode)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = currentDist + weight;

                if (newDist < distances[nextNode]) {
                    distances[nextNode] = newDist;
                    pq.offer(new int[]{newDist, nextNode});
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int N = sc.nextInt();  // 마을 수
        int M = sc.nextInt();  // 도로 수
        int X = sc.nextInt();  // 파티가 열리는 마을

        // 그래프 초기화
        List<List<int[]>> graph = new ArrayList<>();
        List<List<int[]>> reverseGraph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        // 도로 정보 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int t = sc.nextInt();
            graph.get(u).add(new int[]{v, t});
            reverseGraph.get(v).add(new int[]{u, t});  // 반대 방향 그래프
        }

        // 1. X번 마을에서 각 마을로 가는 최단 거리 계산
        int[] distancesFromX = dijkstra(N, graph, X);

        // 2. 각 마을에서 X번 마을로 가는 최단 거리 계산 (반대 방향 그래프)
        int[] distancesToX = dijkstra(N, reverseGraph, X);

        // 3. 가장 오래 걸리는 학생을 찾기
        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            int totalTime = distancesFromX[i] + distancesToX[i];
            maxTime = Math.max(maxTime, totalTime);
        }

        // 결과 출력
        System.out.println(maxTime);

        sc.close();
    }
}