import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int home_count = Integer.parseInt(br.readLine());

        int[] radiuses = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max_size = 0;

        for(int radius : radiuses){
            max_size = Math.max(max_size, radius);
        }

        int max_count = 0;
        int current_count = 0;

        for(int i = 2; i < max_size +1 ; i++){
            current_count = 0;
            for(int radius : radiuses){
                if(radius % i == 0){
                    current_count += 1;
                }
            }
            max_count = Math.max(max_count, current_count);
            if(max_count == home_count){
                break;
            }
        }

        System.out.println(max_count);
    }
}
