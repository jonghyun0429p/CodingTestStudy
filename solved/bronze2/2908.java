import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        StringBuilder reverse = new StringBuilder();

        for(int i = a.length()-1; i >= 0; i--){
            reverse.append(a.charAt(i));
        }
        a = reverse.toString();

        reverse = new StringBuilder();
        for(int i = b.length()-1; i >= 0; i--){
            reverse.append(b.charAt(i));
        }
        b = reverse.toString();

        if(Integer.parseInt(a) > Integer.parseInt(b)){
            System.out.println(a);
        }else{
            System.out.println(b);
        }

    }
}
