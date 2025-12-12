import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int sum = N;

        for(int i = 1; i <= N/2; i++){
            if(N%i == 0){
                sum += i;
            }
        }
        System.out.println(sum*5-24);
    }
}
