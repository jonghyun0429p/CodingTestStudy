import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Math.max(Integer.parseInt(br.readLine()), 40);
        int b = Math.max(Integer.parseInt(br.readLine()), 40);
        int c = Math.max(Integer.parseInt(br.readLine()), 40);
        int d = Math.max(Integer.parseInt(br.readLine()), 40);
        int e = Math.max(Integer.parseInt(br.readLine()), 40);
        System.out.println((a+b+c+d+e)/5);
    }
}