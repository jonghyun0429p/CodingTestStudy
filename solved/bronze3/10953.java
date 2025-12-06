import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T;
        int[] AB = new int[2];

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            AB = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();

            sb.append(AB[0]+AB[1]).append("\n");
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
