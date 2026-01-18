import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String line = br.readLine();
        int surCnt = 0;

        for(int i = 0; i < N; i++){
            if(line.charAt(i) == 'O') surCnt++;
        }

        int can = 0;
        if (N % 2 == 1){
            can++;
        }
        can += N/2;
        if(surCnt >= can){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
