import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1000005;
    static int[] parent = new int[MAX];
    static int[] weather = new int[MAX];
    static int[] lastRainDay = new int[MAX];
    static int[] drinkAt = new int[MAX];

    // Iterative find with path compression to prevent StackOverflow and minimize
    // memory
    public static int find(int i) {
        int root = i;
        while (parent[root] != root) {
            root = parent[root];
        }
        int curr = i;
        while (parent[curr] != root) {
            int next = parent[curr];
            parent[curr] = root;
            curr = next;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        if (st.nextToken() == StreamTokenizer.TT_EOF)
            return;
        int Z = (int) st.nval;

        while (Z-- > 0) {
            if (st.nextToken() == StreamTokenizer.TT_EOF)
                break;
            int n = (int) st.nval;
            st.nextToken();
            int m = (int) st.nval;

            // Step 1: Initialize arrays and read forecast
            for (int i = 0; i <= n; i++)
                lastRainDay[i] = -1;
            for (int i = 0; i <= m; i++)
                parent[i] = i;

            for (int i = 0; i < m; i++) {
                st.nextToken();
                weather[i] = (int) st.nval;
                drinkAt[i] = 0; // Reset result array

                // Optimization: Union-Find skip non-dry days
                if (weather[i] != 0) {
                    parent[i] = i + 1;
                }
            }

            // Path compression for pre-linked components
            for (int i = m - 1; i >= 0; i--) {
                if (weather[i] != 0 && parent[i] != i) {
                    parent[i] = find(parent[i]);
                }
            }

            boolean possible = true;
            for (int i = 0; i < m; i++) {
                int lake = weather[i];
                if (lake == 0)
                    continue;

                // Find the next available dry day after the last time this lake rained
                int dryIdx = find(lastRainDay[lake] + 1);

                if (dryIdx < i) {
                    drinkAt[dryIdx] = lake;
                    // Mark this dry day as used by linking it to the next day
                    parent[dryIdx] = find(dryIdx + 1);
                    lastRainDay[lake] = i;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                pw.println("YES");
                boolean first = true;
                for (int i = 0; i < m; i++) {
                    if (weather[i] == 0) {
                        if (!first)
                            pw.print(" ");
                        pw.print(drinkAt[i]);
                        first = false;
                    }
                }
                pw.println();
            } else {
                pw.println("NO");
            }
        }
        pw.flush();
        pw.close();
    }
}
