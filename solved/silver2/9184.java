import java.io.*;
import java.util.*;

public class Main {

    //탑다운방식으로 풀었는데, 바텀업방식이 훨씬 빠름

    static int[][][] memo = new int[101][101][101];

    public static int w(int a, int b, int c){
        int newA = a+50;
        int newB = b+50;
        int newC = c+50;

        int nowValue;

        if(memo[newA][newB][newC] != 0){
            return memo[newA][newB][newC];
        }else if(newA <= 50 || newB <= 50 || newC <= 50){
            memo[newA][newB][newC] = 1;
            return 1;
        }else if(newA > 70 || newB > 70 || newC > 70){
            nowValue = w(20, 20, 20);
            memo[newA][newB][newC] = nowValue;
            return nowValue;
        }else if(newA < newB && newB < newC){
            nowValue = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            memo[newA][newB][newC] = nowValue;
            return nowValue;
        }else{
            nowValue = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
            memo[newA][newB][newC] = nowValue;
            return nowValue;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums;

        while(true){
            nums = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

            if(nums[0] == -1 && nums[1] == -1 && nums[2] == -1){
                break;
            }

            System.out.printf("w(%d, %d, %d) = %d\n", nums[0], nums[1], nums[2], w(nums[0], nums[1], nums[2]));
        }
    }
}