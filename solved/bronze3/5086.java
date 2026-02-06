import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] list;

        while(true){
            list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(list[0] == 0 && list[1] == 0) break;

            if(list[0] % list[1] == 0 && list[0] / list[1] > 0){
                System.out.println("multiple");
            }else if(list[1] % list[0] == 0 && list[1] / list[0] > 0){
                System.out.println("factor");
            }else{
                System.out.println("neither");
            }
        }

    }
}
