//DP 배낭문제

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] weights = new int[NK[1]+1];
        int maxWeight = 0;

        for(int i = 0; i < NK[0]; i++){
            int[] pack = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int kg = pack[0];
            int weight = pack[1];

            for(int j = NK[1] - kg; j >= 0; j--){
                weights[j+kg] = Math.max(weights[j+kg], weights[j] + weight);
            }
        }

        for(int i = 1; i <= NK[1]; i++){
            maxWeight = Math.max(maxWeight, weights[i]);
        }

        System.out.println(maxWeight);
    }
}
