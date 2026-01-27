import java.io.*;
import java.util.*;

public class Main {

    static int SEQ = 0;

    static class State {
        int x, height;
        boolean isStart;
        int seq;

        public State(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
            this.seq = SEQ++;
        }
    }

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        // 이벤트 정렬용 TreeSet
        TreeSet<State> ts = new TreeSet<>((a, b) -> {
            int cmp = Integer.compare(a.x, b.x);
            if (cmp != 0) return cmp;

            // start 먼저
            if (a.isStart != b.isStart)
                return Boolean.compare(b.isStart, a.isStart);

            // 둘 다 start: 높은 것 먼저
            if (a.isStart) {
                cmp = Integer.compare(b.height, a.height);
                if (cmp != 0) return cmp;
            } 
            // 둘 다 end: 낮은 것 먼저
            else {
                cmp = Integer.compare(a.height, b.height);
                if (cmp != 0) return cmp;
            }

            return Integer.compare(a.seq, b.seq);
        });


        // 입력 처리
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            ts.add(new State(L, H, true));   // 시작
            ts.add(new State(R, H, false));  // 끝
        }

        // 현재 살아있는 높이들 (multiset)
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        heightMap.put(0, 1); // 바닥 높이

        int prevMax = 0;

        // 스위프 라인
        for (State cur : ts) {
            if (cur.isStart) {
                heightMap.put(cur.height,
                        heightMap.getOrDefault(cur.height, 0) + 1);
            } else {
                int cnt = heightMap.get(cur.height);
                if (cnt == 1) heightMap.remove(cur.height);
                else heightMap.put(cur.height, cnt - 1);
            }

            int currMax = heightMap.lastKey();

            // 최대 높이 변화 감지
            if (prevMax != currMax) {
                sb.append(cur.x).append(" ").append(currMax).append(" ");
                prevMax = currMax;
            }
        }

        System.out.println(sb.toString().trim());
    }
}
