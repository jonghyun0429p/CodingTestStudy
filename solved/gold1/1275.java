import java.io.*;
import java.util.*;

public class Main {

    static int N, Q;
    static int[] nums, com;

    static class SegmentTree {
        long[] tree;
        int n;

        public SegmentTree(int n) {
            this.n = n;
            tree = new long[4 * n];
        }

        public long init(int node, int start, int end) {
            if (start == end) {
                return tree[node] = nums[start];
            }
            int mid = (start + end) / 2;
            return tree[node] =
                    init(node * 2, start, mid)
                  + init(node * 2 + 1, mid + 1, end);
        }

        public long getSum(int node, int start, int end, int left, int right) {
            if (right < start || end < left) {
                return 0;
            }
            if (left <= start && end <= right) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            return getSum(node * 2, start, mid, left, right)
                 + getSum(node * 2 + 1, mid + 1, end, left, right);
        }

        public void update(int node, int start, int end, int idx, long diff) {
            if (idx < start || end < idx) {
                return;
            }
            tree[node] += diff;

            if (start != end) {
                int mid = (start + end) / 2;
                update(node * 2, start, mid, idx, diff);
                update(node * 2 + 1, mid + 1, end, idx, diff);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] line = Arrays.stream(br.readLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();
        N = line[0];
        Q = line[1];

        nums = new int[N + 1];
        SegmentTree sTree = new SegmentTree(N);

        int[] input = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        for (int i = 1; i <= N; i++) {
            nums[i] = input[i - 1];
        }

        sTree.init(1, 1, N);

        for (int i = 0; i < Q; i++) {
            com = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

            int x = com[0];
            int y = com[1];
            int a = com[2];
            int b = com[3];

            if (x > y) {
                sb.append(sTree.getSum(1, 1, N, y, x)).append("\n");
            } else {
                sb.append(sTree.getSum(1, 1, N, x, y)).append("\n");
            }

            long diff = (long) b - nums[a];
            nums[a] = b;
            sTree.update(1, 1, N, a, diff);
        }

        System.out.print(sb);
    }
}
