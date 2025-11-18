import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        int min = B;

        int twofive = B*75/100;
        int minusTwo = Math.max(0, B-2000);
        int ten = B*90/100;
        int five = Math.max(0, B-500);

        if(A >= 20){
            min = Math.min(Math.min(Math.min(twofive, minusTwo), ten), five);
        }else if(A >= 15){
            min = Math.min(Math.min(minusTwo, ten), five);
        }else if(A >= 10){
            min = Math.min(ten, five);
        }else if(A >= 5){
            min = five;
        }

        System.out.println(min);
    }
}
