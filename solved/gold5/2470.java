import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] solList;
    static int N, L, R, best, bestL, bestR;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        L = 0;
        R = N-1;
        best = Integer.MAX_VALUE;
        solList = new int[N];

        for(int i = 0; i < N; i++) {
            solList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solList);

        while(L < R) {
            if(Math.abs(solList[L]+solList[R]) < best) {
                best = Math.abs(solList[L]+solList[R]);

                bestL = L;
                bestR = R;
            }

            if(solList[L]+solList[R] > 0) {
                R--;
            }else if(solList[L]+solList[R] == 0) {
                break;
            }else {
                L++;
            }
        }
        System.out.println(solList[bestL]+" "+solList[bestR]);
    }
}
