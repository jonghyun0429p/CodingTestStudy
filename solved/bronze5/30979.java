import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] candies = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;

        for(int i : candies){
            sum += i;
        }

        if(sum >= T){
            System.out.println("Padaeng_i Happy");
        }else{
            System.out.println("Padaeng_i Cry");
        }
    }
}
