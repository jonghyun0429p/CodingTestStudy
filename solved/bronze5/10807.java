import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int cnt = Integer.parseInt(br.readLine());
        int result = 0;
        String[] s = br.readLine().split(" ");

        String value = br.readLine();
        for(String c : s){
            if(c.equals(value)){
                result++;
            }
        }
        System.out.println(result);
    }
}