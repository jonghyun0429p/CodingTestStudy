import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int reverse;

        for(int i = 10; i <= 99; i++){
            reverse = 0;
            reverse += (i % 10) * 10;
            reverse += i / 10;
            if(reverse % 4 != 0) continue;
            if(((i % 10) + (i / 10)) % 6 != 0) continue;
            if(i % 10 == 8 || (i - (i % 10)) / 10 == 8) continue;

            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
