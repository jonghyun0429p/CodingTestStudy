import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if(A >= B*2){
            System.out.println(B);
        }else{
            while(B >= 0){
                B -= 1;
                if(A >= B*2){
                    System.out.println(B);
                    break;
                }
            }
        }

    }
}
