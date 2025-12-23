import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        if(a > b){
            sb.append("flight");
        }else{
            sb.append("high speed rail");
        }

        System.out.println(sb);

    }
}
