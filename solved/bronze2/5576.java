import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] WList, KList;
        int W, K;

        WList = new int[10];
        KList = new int[10];

        W = 0;
        K = 0;

        for(int i = 0; i < 10; i++){
            WList[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < 10; i++){
            KList[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(WList);
        Arrays.sort(KList);

        for(int i = 9; i > 6; i--){
            W += WList[i];
            K += KList[i];
        }

        System.out.println(W+" "+K);
    }
}
