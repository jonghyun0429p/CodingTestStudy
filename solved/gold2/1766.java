import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numAndCount = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = numAndCount[0];
        int M = numAndCount[1];

        int[] degree = new int[N + 1];
        List<List<Integer>> relations = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            relations.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int[] rel = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            relations.get(rel[0]).add(rel[1]);
            degree[rel[1]]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            sb.append(curr).append(" ");

            for (int next : relations.get(curr)) {
                degree[next]--;
                if (degree[next] == 0) {
                    pq.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
