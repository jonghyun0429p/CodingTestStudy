import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N;
	static int[] count;
	static boolean[] visited;
	static ArrayList<Integer>[] rel;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int first, second;
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());    
        

        visited = new boolean[N+1];        
        rel = new ArrayList[N+1];        
        count = new int[N+1];
        
        for(int i = 0; i <= N; i++) {
        	rel[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	first = Integer.parseInt(st.nextToken());
        	second = Integer.parseInt(st.nextToken());
        	
        	count[second]++;
        	rel[first].add(second);
        }
        
        while(N != 0) {
        	for(int i = 1; i < rel.length; i++) {
        		if(!visited[i] && count[i] == 0) {
        			visited[i] = true;
        			sb.append(i).append(" ");
        			N--;
        			for(int n : rel[i]) {
        				count[n]--;
        			}
        		}
        	}
        }
        
        System.out.println(sb.toString().trim());    
    }
}
