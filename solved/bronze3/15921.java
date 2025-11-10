import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sum = 0;

        N = Integer.parseInt(br.readLine());

        if(N == 0) {
            System.out.println("divide by zero");
            return;
        }

        st = new StringTokenizer(br.readLine());



        for(int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
        }

        if(sum == 0) {
            System.out.println("divide by zero");
        }else {
            System.out.println("1.00");
        }
    }
}