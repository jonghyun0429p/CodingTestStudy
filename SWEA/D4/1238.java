import java.io.*;
import java.util.*;

public class Solution {
    static final int MAX = 100;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            boolean[][] adjDup = new boolean[MAX + 1][MAX + 1];
            List<Integer>[] graph = new ArrayList[MAX + 1];
            for (int i = 1; i <= MAX; i++) graph[i] = new ArrayList<>();

            int[] arr = new int[L];
            int idx = 0;
            while (idx < L) {
                if (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                    continue;
                }
                arr[idx++] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < L; i += 2) {
                int from = arr[i];
                int to = arr[i + 1];
                if (!adjDup[from][to]) {
                    adjDup[from][to] = true;
                    graph[from].add(to);
                }
            }

            boolean[] visited = new boolean[MAX + 1];
            Queue<Integer> q = new ArrayDeque<>();
            q.add(start);
            visited[start] = true;

            int answer = start;
            while (!q.isEmpty()) {
                int size = q.size();
                int levelMax = 0;
                for (int i = 0; i < size; i++) {
                    int cur = q.poll();
                    levelMax = Math.max(levelMax, cur);
                    for (int nxt : graph[cur]) {
                        if (!visited[nxt]) {
                            visited[nxt] = true;
                            q.add(nxt);
                        }
                    }
                }
                answer = levelMax;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
