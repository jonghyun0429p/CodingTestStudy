import java.io.*;
import java.util.*;

public class Main {

    static class Jewelry {
        int weight, value;
        public Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewelry[] jewels = new Jewelry[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewelry(m, v);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, (a, b) -> a.weight - b.weight);
        Arrays.sort(bags);

        PriorityQueue<Jewelry> pq = new PriorityQueue<>(
                (a, b) -> b.value - a.value
        );

        long sum = 0;
        int idx = 0;

        for (int i = 0; i < K; i++) {
            int capacity = bags[i];

            while (idx < N && jewels[idx].weight <= capacity) {
                pq.add(jewels[idx]);
                idx++;
            }

            if (!pq.isEmpty()) {
                sum += pq.poll().value;
            }
        }

        System.out.println(sum);
    }
}
