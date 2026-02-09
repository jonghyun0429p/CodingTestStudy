import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int A = list[0];
        int B = list[1];
        int C = list[2];

        int[] array = new int[101];

        for(int i = 0; i < 3; i++){
            list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int j = list[0]; j < list[1]; j++){
                array[j] += 1;
            }
        }
        int sum = 0;

        for(int n : array){
            if(n == 3){
                sum += n*C;
            }else if(n == 2){
                sum += n*B;
            }else if(n == 1){
                sum += n*A;
            }
        }

        System.out.println(sum);
    }
}
