import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i%2 == 0){
                    sb.append("*").append(" ");
                }else{
                    sb.append(" ").append("*");
                }
            }
            if(i%2 == 0){
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

    }
}
