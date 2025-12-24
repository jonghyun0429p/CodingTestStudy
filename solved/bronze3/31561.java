import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        double answer = 0;
        if(m<30){
            answer = m/2.0;
        }else{
            m -= 30;
            answer = 15 + m /(2/3.0);
        }

        System.out.println(answer);

    }
}
