import java.io.*;
import java.util.*;

public class Main{
    public static void main(String arg[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] s = br.readLine().split(" ");
        
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        
        for(int i = 0; i < x; i++) {
        	sb.append("1");
        }
        x = Integer.parseInt(sb.toString());
        sb = new StringBuilder();
        
        for(int i = 0; i < y; i++) {
        	sb.append("1");
        }
        y = Integer.parseInt(sb.toString());
        
        System.out.println(x+y);
        
    }
}