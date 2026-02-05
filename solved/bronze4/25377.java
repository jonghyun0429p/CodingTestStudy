import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int max = Integer.MAX_VALUE;

        int[] list;

        for(int i = 0; i < T; i++){
            list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(list[0] > list[1]) continue;

            if(max >= list[1]){
                max = list[1];
            }
        }

        if(max == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(max);
        }
    }
}
