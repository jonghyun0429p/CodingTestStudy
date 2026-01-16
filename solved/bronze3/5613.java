import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int result = 0;
        String line = br.readLine();
        result = Integer.parseInt(line);
        while(line != "="){
            line = br.readLine();
            if(line.equals("+")){
                result += Integer.parseInt(br.readLine());
            }else if(line.equals("-")){
                result -= Integer.parseInt(br.readLine());
            }else if(line.equals("*")){
                result *= Integer.parseInt(br.readLine());
            }else if(line.equals("/")){
                result /= Integer.parseInt(br.readLine());
            }else{
                break;
            }
        }
        System.out.println(result);
    }
}
