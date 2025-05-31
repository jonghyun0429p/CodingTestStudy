//bfs 구현 다익스트라로도 가능한데 나중에 해보자.
import java.io.*;
import java.util.*;

public class Main {

    static int MAX_POINT = 200000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getTime(NK[0], NK[1]));

    }

    public static int getTime(int N, int K){

        boolean[] visited = new boolean[MAX_POINT+1];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {N, 0});
        visited[N] = true;


        while(!q.isEmpty()){
            int[] current = q.poll();
            visited[current[0]] = true;

            if(current[0] == K){
                return current[1];
            }

            int start = current[0];
            int teleport = start*2;
            int go = start+1;
            int back = start-1;
            int count = current[1];

            if(teleport <= MAX_POINT) {
                if (!visited[teleport]) {
                    q.offerFirst(new int[]{teleport, count});
                }
            }

            if(go <= MAX_POINT) {
                if (!visited[go]) {
                    q.offer(new int[]{go, count+1});
                }
            }

            if(0 <= back) {
                if (!visited[back]) {
                    q.offer(new int[]{back, count+1});
                }
            }
        }
        return 0;
    }
}
