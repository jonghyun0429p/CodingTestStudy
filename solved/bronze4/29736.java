import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int count = 0;

        for(int i = A; i <= B; i++){
            if(i >= K-X && i <= K+X){
                count++;
            }
        }

        if(count == 0){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(count);
        }
    }
}
