import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int onionA = 1;
        int onionB = 1;
        int temp;

        for(int i = 0; i < N; i++){
            onionA += A;
            onionB += B;

            if(onionB > onionA){
                temp = onionB;
                onionB = onionA;
                onionA = temp;
            }else if(onionB == onionA){
                onionB -= 1;
            }
        }

        System.out.println(onionA+" "+onionB);

    }
}
