import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int serverCount = 0;
        int time = 0;
        Queue<Integer> serverTime = new ArrayDeque<>();
        int capablePlayer = 0;

        for(int player : players){
            int size = serverTime.size();
            for(int i = 0; i < size; i++){
                if(serverTime.peek() > time - k){
                    break;
                }
                serverTime.poll();
                serverCount -= 1;
            }

            capablePlayer = serverCount * m;
            if(player - capablePlayer > m-1){
                int oldServerCount = serverCount;
                serverCount += (player - capablePlayer) / m;

                if(oldServerCount < serverCount){
                    int dif = serverCount - oldServerCount;
                    for(int i = 0; i < dif; i++){
                        serverTime.add(time);
                        answer += 1;
                    }
                }
            }
            time += 1;
        }

        return answer;
    }
}