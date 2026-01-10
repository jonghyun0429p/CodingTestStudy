import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger i = new BigInteger(br.readLine()).pow(2);
        BigInteger max = new BigInteger("100000000");
        if(i.compareTo(max)>0){
            System.out.println("Time limit exceeded");
        }else{
            System.out.println("Accepted");
        }
    }
}
