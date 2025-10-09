import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count; i++){
            String[] line = br.readLine().split(" ");

            for(int j = 2; j < line.length; j++){
                System.out.print(line[j]+" ");
            }

            System.out.print(line[0]+" ");
            System.out.println(line[1]+" ");
        }
    }
}