import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        int d, n, s, p;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            String[] line = br.readLine().split(" ");

            d = Integer.parseInt(line[0]);
            n = Integer.parseInt(line[1]);
            s = Integer.parseInt(line[2]);
            p = Integer.parseInt(line[3]);

            int par = d + n * p;
            int ser = n * s;

            if(par > ser){
                System.out.println("do not parallelize");
            }else if(par < ser){
                System.out.println("parallelize");
            }else{
                System.out.println("does not matter");
            }
        }
    }
}