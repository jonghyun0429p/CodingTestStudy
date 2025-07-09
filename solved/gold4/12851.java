import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈
        int K = Integer.parseInt(st.nextToken()); // 동생

        int[] time = new int[MAX];      // 각 위치까지의 최소 시간
        int[] count = new int[MAX];     // 해당 시간에 도달하는 방법 수

        Arrays.fill(time, -1);          // -1로 초기화 (방문하지 않음)

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        time[N] = 0;
        count[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next >= MAX) continue;

                // 첫 방문이면 큐에 넣고 시간 및 경로 수 갱신
                if (time[next] == -1) {
                    time[next] = time[now] + 1;
                    count[next] = count[now];
                    q.offer(next);
                }
                // 같은 시간에 도달한 경우 → 경로 수 누적
                else if (time[next] == time[now] + 1) {
                    count[next] += count[now];
                }
            }
        }

        System.out.println(time[K]);
        System.out.println(count[K]);
    }
}