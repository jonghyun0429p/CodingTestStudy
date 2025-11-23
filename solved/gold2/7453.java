import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long[] ListA, ListB, ListC, ListD;
    static long[] ListAB, ListCD;
    static long Count, aCount, bCount, aVal, bVal;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Count = 0;
        N = Integer.parseInt(br.readLine());
        ListA = new long[N];
        ListB = new long[N];
        ListC = new long[N];
        ListD = new long[N];
        ListAB = new long[N*N];
        ListCD = new long[N*N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            ListA[i] = Integer.parseInt(st.nextToken());
            ListB[i] = Integer.parseInt(st.nextToken());
            ListC[i] = Integer.parseInt(st.nextToken());
            ListD[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                ListAB[i*N+j] = ListA[i] + ListB[j];
                ListCD[i*N+j] = ListC[i] + ListD[j];
            }
        }

        Arrays.sort(ListAB);
        Arrays.sort(ListCD);

        int left = 0;
        int right = N*N-1;
        long sum;

        while(left < N*N && right >= 0){
            sum = ListAB[left] + ListCD[right];
            if(sum == 0){
                aCount = 0;
                bCount = 0;
                aVal = ListAB[left];
                bVal = ListCD[right];

                while(left < N*N && ListAB[left] == aVal){
                    left++;
                    aCount++;
                }

                while (right >= 0 && ListCD[right] == bVal){
                    right--;
                    bCount++;
                }

                Count += aCount * bCount;
            }else if(sum > 0) right--;
            else left++;
        }

        System.out.println(Count);
    }
}
