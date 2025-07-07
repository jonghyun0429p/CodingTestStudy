import java.util.*;

class Solution {

    static int K;
    static int N;
    static int minWaitingTime = Integer.MAX_VALUE;  // 최소 대기 시간만 저장

    public int solution(int k, int n, int[][] reqs) {
        K = k;
        N = n;

        getMentoWays(0, 0, new ArrayList<>(), reqs);

        return minWaitingTime;
    }

    public void getMentoWays(int k, int n, List<Integer> list, int[][] reqs) {
        if (k == K) {
            if (n == N) {
                int[][] mentos = new int[K][];
                for (int j = 0; j < K; j++) {
                    mentos[j] = new int[list.get(j)];
                }
                int waitingTime = getWaitingTime(mentos, reqs);
                minWaitingTime = Math.min(minWaitingTime, waitingTime);
            }
            return;
        }

        //반복 가능한 횟수는 멘토의 수만큼 가능할 것 같지만, 사실 남은 유형에도 적어도 한 명은 들어가야하므로,
        //남은 멘토 - 남은 유형이면 반복하면 가능.
        int remainMento = N - n;
        //1을 더해 주어야함. 왜냐면 현재 진행하는 타입은 당연히 하나가 들어갈것이므로 고려할 필요가 없어짐.
        int remainType = K - k - 1;

        for (int i = 1; i <= remainMento - remainType; i++) {
            list.add(i);
            getMentoWays(k + 1, n + i, list, reqs);
            list.remove(list.size() - 1);
        }
    }

    public int getWaitingTime(int[][] mentos, int[][] reqs) {
        int waitingTime = 0;

        for (int[] arr : reqs) {
            int startTime = arr[0];
            int duration = arr[1];
            int type = arr[2] - 1;

            int minEnd = Integer.MAX_VALUE;
            int minIndex = -1;
            boolean assigned = false;

            for (int i = 0; i < mentos[type].length; i++) {
                if (mentos[type][i] <= startTime) {
                    mentos[type][i] = startTime + duration;
                    assigned = true;
                    break;
                } else {
                    if (mentos[type][i] < minEnd) {
                        minEnd = mentos[type][i];
                        minIndex = i;
                    }
                }
            }

            if (!assigned) {
                waitingTime += minEnd - startTime;
                mentos[type][minIndex] = minEnd + duration;
            }
        }

        return waitingTime;
    }
}
