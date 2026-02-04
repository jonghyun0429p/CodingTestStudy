import java.io.*;
import java.util.*;

public class Main {

	static int N, Q;
	static int[] line;
	static HashMap<Integer, HashSet<Integer>> map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		map = new HashMap<>();
		
		line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		N = line[0];
		Q = line[1];
		
		
		
		for(int i = 1; i <= N; i++) {
			line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			map.put(i, new HashSet<Integer>());
			
			for(int n = 0; n < line[0]; n++) {
				map.get(i).add(line[n+1]);
			}
		}
		
		for(int i = 0; i < Q; i++) {
			line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			if(line[0] == 2) {
				sb.append(map.get(line[1]).size()).append("\n");
			}else if(line[0] == 1) {
				if(map.get(line[1]).size() > map.get(line[2]).size()) {
					map.get(line[1]).addAll(map.get(line[2]));
					map.replace(line[2], new HashSet());
				}else {
					map.get(line[2]).addAll(map.get(line[1]));
					map.replace(line[1], map.get(line[2]));
					map.replace(line[2], new HashSet());
				}
			}			
		}
		
		System.out.println(sb.toString());
		
		
		
		
		
	}
}
