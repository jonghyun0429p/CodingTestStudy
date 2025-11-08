import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static String line;
    static char c;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            sb.append("String #").append(tc).append("\n");

            line = br.readLine();

            for(int i = 0; i < line.length(); i++){
                c = line.charAt(i);
                if((int) c == (int) 'Z'){
                    c = 'A';
                }else{
                    c = (char) (c+1);
                }
                sb.append(c);
            }

            if(tc != T){
                sb.append("\n\n");
            }
        }
        System.out.println(sb.toString());
    }
}
