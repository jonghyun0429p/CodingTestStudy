import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count = 0;

        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        for(int i = 0; i < N; i++){
            count += Integer.parseInt(String.valueOf(line.charAt(i))) % 2;
        }

        if(N%2==0&&count == N/2){
            System.out.println(-1);
        }else if(N-count > count){
            System.out.println(0);
        }else{
            System.out.println(1);
        }


    }
}
