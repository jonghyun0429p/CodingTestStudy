import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int[] line = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();

        for(int a : line){
            sum += a;
        }

        System.out.println(sum);
    }
}
