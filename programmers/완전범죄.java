import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        //dp를 이용해서 풀었습니다. 원래는 int[][] dp를 이용해서, a가 가장 작고, b가 가능한 값만 가지치기를 하면서 구했습니다.

        int N = info.length;
        int INF = n+m+1;
        int answer = INF;

        //dp 배열을 만들고, INF로 초기화.
        int[] dp = new int[m];

        Arrays.fill(dp, INF);
        //시작점은 보석을 저장하지 않은 상태이므로, 둘다 0, 0을 저장.
        dp[0] = 0;

        for(int i = 1; i <= N; i++){
            int ai = info[i-1][0];
            int bi = info[i-1][1];
            int[] next = new int[m];
            Arrays.fill(next, INF);

            for(int oldB = 0; oldB < m; oldB++){
                if(dp[oldB] == INF){
                    continue;
                }
                int currA = dp[oldB];

                int newA = currA + ai;
                if(newA < n){
                    //b는 유지, a값 증가
                    next[oldB] = Math.min(next[oldB], newA);
                    answer = Math.min(minA, newA);
                }

                int newB = oldB + bi;
                if(newB < m){
                    //a는 유지, b값 증가
                    next[newB] = Math.min(next[newB], currA);
                }
            }
            dp = next;
        }
//        int answer = INF;
//        for(int b = 0; b < m; b++){
//            answer = Math.min(answer, dp[b]);
//        }

        return (answer == INF ? -1 : minA);
    }
}
