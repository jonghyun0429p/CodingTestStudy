import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, L, C, R, BestL, BestC, BestR;
    static long Min, cur;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        //용액 값들 받기.
        values = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        //용액 값 정렬
        Arrays.sort(values);

        //접근 방법으로 2개의 왼쪽 오른쪽 값과 1개의 중간값을 수정해가면서 활용하는 것
        //중간값을 왼쪽에서 오른쪽으로 이동하면서 이전 값을 저장하고 절대값이 커져버리면 멈추고, 그전 자리에서 멀리 있는 L R 조정.
        Min = Long.MAX_VALUE;

        //그냥 일단 완탐으로 구해보자.

        for (int i = 0; i < N - 2; i++) {
            L = i;
            C = i + 1;
            R = N - 1;
            while(L < C && C < R) {
                cur = (long)values[L]+values[C]+values[R];
                if(cur == 0) {
                    System.out.println(values[L]+" "+values[C]+" "+values[R]);
                    return;
                }else if(Min > Math.abs(cur)) {
                    Min = Math.abs(cur);
                    BestL = L;
                    BestC = C;
                    BestR = R;
                }
                if(cur > 0) R--;
                else C++;
            }
            L++;
        }

        System.out.println(values[BestL] + " " + values[BestC] + " " + values[BestR]);
    }
}
