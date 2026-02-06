import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] list;
        list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = list[1] + list[1] * list[2];

        System.out.println(sum);
    }
}
