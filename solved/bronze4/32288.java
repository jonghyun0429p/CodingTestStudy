import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String line = br.readLine();

        for(int i = 0; i < N; i++){
            if(line.charAt(i) == 'I'){
                sb.append('i');
            }else if(line.charAt(i) == 'l') {
                sb.append('L');
            }else {
                sb.append(line.charAt(i));
            }
        }

        System.out.println(sb);
    }
}
