import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] CList, DList;
        int H, time, damage;

        CList = new int[3];
        DList = new int[3];

        time = 0;
        damage = 0;

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());

            CList[i] = Integer.parseInt(st.nextToken());
            DList[i] = Integer.parseInt(st.nextToken());

            damage += DList[i];
        }

        H = Integer.parseInt(br.readLine());
        while(damage < H){
            time++;
            for(int i = 0; i < 3; i++){
                if(time%CList[i] == 0){
                    damage += DList[i];
                }
            }
        }

        System.out.println(time);


    }
}
