import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 무방향 그래프를 한 점을 루트로 삼아서 트리로 관리하는 거.
    // 루트를 먼저 큐로 넣고 그거랑 연관있는걸 아래로 내리는거?

    static int N, R, Q;
    static ArrayList<Integer>[] graphs;
    static int[] counts;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a, b;

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graphs = new ArrayList[N+1];
        counts = new int[N+1];

        for(int i = 0; i <= N; i++) {
            graphs[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            graphs[a].add(b);
            graphs[b].add(a);
        }

        countTree(R, 0);

        for(int i = 0; i < Q; i++) {
            a = Integer.parseInt(br.readLine());

            sb.append(counts[a]).append("\n");
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        System.out.println(sb.toString());
    }

    public static void countTree(int curNode, int parent) {
        counts[curNode] = 1;
        for(int i : graphs[curNode]) {
            if(i != parent) {
                countTree(i, curNode);
                counts[curNode] += counts[i];
            }
        }
    }
}
