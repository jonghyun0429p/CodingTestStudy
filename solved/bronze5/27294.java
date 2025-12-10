import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        if(S == 1){
            System.out.println(280);
        }else{
            if(11 < T && T < 17){
                System.out.println(320);
            }
            else{
                System.out.println(280);
            }
        }
    }
}
