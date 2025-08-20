import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T, N, maxValue;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            int odd = 0;
            int even = 0;
            maxValue = 0;
            trees = new int[N];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                int cur = Integer.parseInt(st.nextToken());
                trees[i] = cur;
                maxValue = Math.max(maxValue, cur);
            }

            for(int i : trees) {
                int temp = maxValue - i;
                if(temp%2 == 1) odd++;
                even += temp/2;
            }

            int max = even*2;
            int remain = even-odd;
            boolean isEven = true;

            while(remain > 0) {
                if(isEven) {
                    if(remain > 1) {
                        max--;
                        remain -= 2;
                    }else {
                        break;
                    }
                    isEven = false;
                }else if(!isEven) {
                    max--;
                    remain--;
                    isEven = true;
                }
            }

            int result = Math.max(odd*2-1, max);

            System.out.printf("#%d %d\n", tc, result);
        }
    }
}