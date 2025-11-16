import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count = 0;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++){
            for(int j = i; j <= N; j++){
                count += i + j;
            }
        }

        System.out.println(count);
    }
}
