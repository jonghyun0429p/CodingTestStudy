import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int asc = 0;
        int sum;
        String line = br.readLine();
        char c;

        for(int i = 0; i < line.length(); i++){
            c = line.charAt(i);
            asc = (int)c;
            sum = 0;

            while(asc > 0){
                sum += asc%10;
                asc = asc/10;
            }

            for(int j = 0; j < sum; j++){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
