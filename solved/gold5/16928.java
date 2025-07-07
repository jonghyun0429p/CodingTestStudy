import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static HashMap<Integer,Integer> loadMap;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        loadMap = new HashMap<>();
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[101];
        Arrays.fill(visited,false);

        for(int i = 0; i < NM[0]; i++){
            int[] N = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            loadMap.put(N[0],N[1]);
        }

        for(int i = 0; i < NM[1]; i++){
            int[] M = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            loadMap.put(M[0],M[1]);
        }

        System.out.print(getMinRoll());

    }

    public static int getMinRoll(){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0});
        visited[0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == 100){
                return cur[1];
            }

            for(int i = 6; i > 0; i--){
                int newCur = cur[0] + i;

                if(newCur < 101){
                    if(!visited[newCur]){
                        visited[newCur] = true;
                        if(loadMap.containsKey(newCur)){
                            q.add(new int[]{loadMap.get(newCur), cur[1]+1});
                        }
                        else{
                            q.add(new int[]{newCur, cur[1]+1});
                        }
                    }
                }
            }
        }

        return -1;
    }
}
