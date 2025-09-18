import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Graph{
		int end, cost;
		
		Graph(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
	}
	
	static int V, S, E, C;
	static ArrayList<ArrayList<Graph>> graphs;
	static boolean[] visited;
	static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        graphs = new ArrayList<>();
        
        for(int i = 0; i <= V; i++) {
        	graphs.add(new ArrayList<>());
        }
        
        for(int i = 0; i < V; i++) {
        	st = new StringTokenizer(br.readLine());
        	S = Integer.parseInt(st.nextToken());
        	while(true) {
            	E = Integer.parseInt(st.nextToken());
            	
            	if(E == -1) break;
            	
            	C = Integer.parseInt(st.nextToken());
            	
            	graphs.get(S).add(new Graph(E, C));
            	graphs.get(E).add(new Graph(S, C));        		
        	}
        }
        
        int[] far = getFartest(1);
        int[] real = getFartest(far[1]);
        
        System.out.println(real[0]);
    } 
    
    //오름차순으로 적재하고.
    static int[] getFartest(int start) {
    	dist = new int[V+1];
        visited = new boolean[V+1];
    	Queue<int[]> q = new ArrayDeque<>();
    	q.add(new int[] {start, 0});
    	visited[start] = true;
    	
    	while(!q.isEmpty()) {
    		int[] g = q.poll();
    		for(Graph s : graphs.get(g[0])) {
    			if(dist[s.end] < s.cost && !visited[s.end]) {
    				visited[s.end] = true;
    				dist[s.end] = s.cost + g[1];
    				q.add(new int[] {s.end, s.cost+g[1]});
    			}
    		}
    	}
    	
    	int max = 0;
    	int idx = 0;
    	for(int i = 1; i <= V; i++) {
    		if(max < dist[i]) {
    			max = dist[i];
    			idx = i;
    		}
    	}
    	return new int[] {max, idx};
    }
}
