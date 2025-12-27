import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        long cnt = 0;

        long m = Integer.parseInt(br.readLine());

        long[] file = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long size = Integer.parseInt(br.readLine());

        for(long i : file){
            cnt += (int) (i/size);
            if(i%size > 0){
                cnt++;
            }
        }


        System.out.println(cnt*size);

    }
}
