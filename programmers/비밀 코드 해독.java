import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;

        List<int[]> list = new ArrayList<int[]>();

        for(int a = 1; a <= n-4; a++){
            for(int b = a + 1; b <= n-3; b++){
                for(int c = b + 1; c <= n-2; c++){
                    for(int d = c + 1; d <= n - 1; d++){
                        for(int e = d + 1; e <= n; e++){
                            if(ans[0] == getMatch(q[0], new int[] {a, b, c, d ,e})){
                                list.add(new int[] {a, b, c, d, e});
                            }
                        }
                    }
                }
            }
        }

        for (int i = 1; i < ans.length; i++) {
            List<int[]> filtered = new ArrayList<>();
            for (int[] num : list) {
                if (ans[i] == getMatch(q[i], num)) {
                    filtered.add(num);
                }
            }
            list = filtered;
        }

        answer = list.size();

        return answer;
    }

    public static int getMatch(int[] q, int[] code){
        int sameCount = 0;

        for(int i : code){
            for(int j : q){
                if(i == j){
                    sameCount += 1;
                }
            }
        }

        return sameCount;
    }
}