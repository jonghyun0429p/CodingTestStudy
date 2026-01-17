import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] line;
        int sum, diff;
        int value = -1;
        int goal = 512;
        int approximation = 512;
        boolean okay = false;
        for(int i = 0; i < T; i++){
            sum = 0;
            line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(okay) continue;
            for (int a : line){
                sum += a;
            }
            diff = sum - goal;
            if(diff == 0){
                okay = true;
                value = goal;
            } else if (diff > 0 && diff < approximation) {
                approximation = diff;
                value = sum;
            }
        }
        System.out.println(value);
    }
}
