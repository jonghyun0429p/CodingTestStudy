import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, count;
    static Set<Integer> set;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            set = new HashSet<>();
            count = 0;
            int mul = 1;
            int temp = 0;

            while(set.size() != 10){
                count++;

                temp = N*mul;
                mul++;
                for(int i = temp; i > 0; i = i/10){
                    set.add(i%10);
                }
            }
            mul--;
            System.out.printf("#%d %d\n", tc, N*mul);
        }
    }
}
