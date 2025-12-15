import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int rate, min;
        int[] point = new int[101];

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            point[Integer.parseInt(st.nextToken())] += 1;
        }

        st = new StringTokenizer(br.readLine());
        rate = Integer.parseInt(st.nextToken());

        sb.append(N*rate/100).append(" ");

        min = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int i = 100; i >= min; i--){
            cnt += point[i];
        }

        sb.append(cnt);

        System.out.println(sb);
    }
}
