import java.io.*;
import java.util.*;

public class Main {

    static class SegmentTree {
        int n;
        long[] tree, lazy;

        SegmentTree(int n) {
            this.n = n;
            tree = new long[4 * n];
            lazy = new long[4 * n];
        }

        void push(int node, int start, int end) {
            if (lazy[node] != 0) {
                tree[node] += (end - start + 1) * lazy[node];
                if (start != end) {
                    lazy[node * 2] += lazy[node];
                    lazy[node * 2 + 1] += lazy[node];
                }
                lazy[node] = 0;
            }
        }

        void update(int node, int start, int end, int left, int right) {
            push(node, start, end);
            if (right < start || end < left) return;

            if (left <= start && end <= right) {
                lazy[node]++;
                push(node, start, end);
                return;
            }

            int mid = (start + end) / 2;
            update(node * 2, start, mid, left, right);
            update(node * 2 + 1, mid + 1, end, left, right);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        long query(int node, int start, int end, int left, int right) {
            push(node, start, end);
            if (right < start || end < left) return 0;
            if (left <= start && end <= right) return tree[node];

            int mid = (start + end) / 2;
            return query(node * 2, start, mid, left, right)
                 + query(node * 2 + 1, mid + 1, end, left, right);
        }
    }

    static final int DAY = 86400;

    static int toSec(String s) {
        String[] t = s.split(":");
        return Integer.parseInt(t[0]) * 3600
             + Integer.parseInt(t[1]) * 60
             + Integer.parseInt(t[2]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        SegmentTree st = new SegmentTree(DAY);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" - ");
            int start = toSec(parts[0]);
            int end = toSec(parts[1]);

            if (start <= end) {
                st.update(1, 0, DAY - 1, start, end);
            } else {
                st.update(1, 0, DAY - 1, start, DAY - 1);
                st.update(1, 0, DAY - 1, 0, end);
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            String[] parts = br.readLine().split(" - ");
            int start = toSec(parts[0]);
            int end = toSec(parts[1]);

            long sum;
            long len;

            if (start <= end) {
                sum = st.query(1, 0, DAY - 1, start, end);
                len = end - start + 1;
            } else {
                sum = st.query(1, 0, DAY - 1, start, DAY - 1)
                    + st.query(1, 0, DAY - 1, 0, end);
                len = (DAY - start) + (end + 1);
            }

            sb.append((double) sum / len).append('\n');
        }

        System.out.print(sb);
    }
}
