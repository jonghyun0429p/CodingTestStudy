//bfs, 다익스트라

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] VE = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int startNum = Integer.parseInt(br.readLine());

        List<List<int[]>> list = new ArrayList<>();
        int[] dist = new int[VE[0]+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNum] = 0;

        for(int i = 0; i <= VE[0]; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < VE[1]; i++){
            int[] nodeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.get(nodeInfo[0]).add(new int[] {nodeInfo[1], nodeInfo[2]});
        }

        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        q.offer(new int[] {startNum, 0});

        while(!q.isEmpty()){
            int[] current = q.poll();

            if (current[1] > dist[current[0]]) continue;

            List<int[]> nodes = list.get(current[0]);

            for(int[] node : nodes){
                if(dist[node[0]] > current[1] + node[1]){
                    dist[node[0]] = current[1] + node[1];
                    q.offer(new int[] {node[0], dist[node[0]]});
                }
            }
        }

        for(int i = 1; i <= VE[0]; i++){
            if(dist[i]==Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
    }
}
