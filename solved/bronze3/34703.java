import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[] days = new boolean[5];
        int emptyDay = 5;
        int day;

        for(int i = 0; i < N; i++){
            day = Integer.parseInt(br.readLine());
            days[day-1] = true;
        }

        for(int i = 0; i < 5; i++){
            if(days[i]){
                emptyDay--;
            }
        }

        if(emptyDay > 0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
