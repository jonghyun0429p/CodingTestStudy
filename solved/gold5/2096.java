//dp
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 최대값 DP 배열
        int[] dpMax = new int[3];
        // 최소값 DP 배열
        int[] dpMin = new int[3];

        // 첫 줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int val = Integer.parseInt(st.nextToken());
            dpMax[i] = val;
            dpMin[i] = val;
        }

        // DP 진행
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 임시 배열 생성
            int[] nextMax = new int[3];
            int[] nextMin = new int[3];

            // 최대값 DP 계산
            nextMax[0] = a + Math.max(dpMax[0], dpMax[1]);
            nextMax[1] = b + Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]);
            nextMax[2] = c + Math.max(dpMax[1], dpMax[2]);

            // 최소값 DP 계산
            nextMin[0] = a + Math.min(dpMin[0], dpMin[1]);
            nextMin[1] = b + Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]);
            nextMin[2] = c + Math.min(dpMin[1], dpMin[2]);

            // 갱신
            dpMax = nextMax;
            dpMin = nextMin;
        }

        // 결과 출력
        int maxResult = Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]);
        int minResult = Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]);

        System.out.println(maxResult + " " + minResult);
    }
}
