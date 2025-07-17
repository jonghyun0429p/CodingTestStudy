import java.io.*;
import java.util.*;

public class Main {
	
	//치킨집위치를 모두 기억한다면, 그 좌표와 치킨집의 거리를 각각 구하고 치킨 거리 계산 가능.
	//치킨집 수를 알려주네 M개만 남기고 나머지는 지워야하는데, M개를 지워보면서 각각 구해야하는건가 조합으로?
	//최대 13개면 최악의 경우의 수는 13C6인 1716이게 되고, 이 갯수만큼 다시 구해야하는데, 크기가 50x50까지 가능
	//그러면 집이 최대 2N개 그러면 100개 까지 가능
	//1716*100 약 2000*100 = 200,000번 연산이면 할만 하네.
	
	static int[][] village;
	static List<int[]> homes;
	static List<int[]> stores;
	static int N, M;
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int[] NandM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NandM[0];
        M = NandM[1];
        village = new int[N][N];
        homes = new ArrayList<>();
        stores = new ArrayList<>();
        List<int[]> store = new ArrayList<>();
       
        for(int i = 0; i < N; i++) {
        	int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	for(int j = 0; j < N; j++) {
        		int cur = line[j];
        		if(cur == 1) {
        			homes.add(new int[] {i, j});
        		}else if(cur == 2) {
        			stores.add(new int[] {i, j});
        		}
        	}
        }
       
        System.out.println(backtracking(0, 0, store));        
    }
   
    public static int backtracking(int depth, int start, List<int[]> selected) {
    	
        if (depth == M) {
            return getChickenDist(selected);
        }

        int min = Integer.MAX_VALUE;

        for (int i = start; i < stores.size(); i++) {
            selected.add(stores.get(i));
            min = Math.min(min, backtracking(depth + 1, i + 1, selected));
            selected.remove(selected.size() - 1);
        }

        return min;
    }
   
    static int getChickenDist(List<int[]> store) {
    	int result = 0;
    	int minDis;
    	for(int i = 0; i < homes.size(); i++) {
    		minDis = Integer.MAX_VALUE;
    		for(int j = 0; j < store.size(); j++) {
    			minDis = Math.min(minDis, Math.abs(homes.get(i)[0] - store.get(j)[0]) + Math.abs(homes.get(i)[1] - store.get(j)[1]));
    		}
    		result += minDis;
    	}
    	
    	return result;
    }
}