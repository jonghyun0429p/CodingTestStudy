import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        int[] town = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] differ = new int[count-1];
        int min_dif = 1000000;
        int same_dif_count = 0;

        for(int i = 0; i < count - 1; i++){
            differ[i] = town[i+1] - town[i];
            if(min_dif == differ[i]){
                same_dif_count += 1;
            }else if(min_dif > differ[i]){
                same_dif_count = 1;
                min_dif = differ[i];
            }
        }
        System.out.println(same_dif_count);
    }
}
