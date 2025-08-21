import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int mask = (1 << N) - 1;
            if((M&mask) == mask){
                System.out.println("#"+tc+" ON");
            }else{
                System.out.println("#"+tc+" OFF");
            }
        }
    }
}
