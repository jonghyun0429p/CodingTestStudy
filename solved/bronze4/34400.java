import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int time = Integer.parseInt(br.readLine());

            time = time%25;

            if(time < 17){
                sb.append("ONLINE\n");
            }else{
                sb.append("OFFLINE\n");
            }
        }

        System.out.println(sb);

    }
}
