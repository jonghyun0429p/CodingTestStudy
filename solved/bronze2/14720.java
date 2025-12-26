import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt = 0;
        int cur = 6;
        for(int i : line){
            if(cur == 1 && i == 2){
                cur = i;
                cnt++;
            }else if(cur == 0 && i == 1){
                cur = i;
                cnt++;
            }else if((cur == 2 || cnt == 0) && i == 0){
                cur = i;
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
