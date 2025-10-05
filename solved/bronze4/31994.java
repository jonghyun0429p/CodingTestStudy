import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        String semina = "";

        for(int i = 0; i < 7; i++){
            String[] line = br.readLine().split(" ");
            if(max < Integer.parseInt(line[1])){
                max = Integer.parseInt(line[1]);
                semina = line[0];
            }
        }

        System.out.println(semina);
    }
}