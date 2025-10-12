import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String[] patterns = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="}; // dz= 먼저!
        for (String p : patterns) {
            s = s.replace(p, "*");
        }
        System.out.println(s.length());
    }
}
