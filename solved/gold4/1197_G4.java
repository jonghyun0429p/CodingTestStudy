import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node>{
		int prev, to, weight;
		
		Node(int prev, int to, int weight){
			this.prev = prev;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
		
	}
	
	static int V, E;
	static int[] parents;
	static int[][] edges;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        parents = new int[V+1];
        for(int i = 1; i <= V; i++) {
        	parents[i] = i;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        int size = pq.size();
        int total = 0;
        for(int i = 0; i < size; i++) {
        	Node node = pq.poll();
        	int to = find(node.to);
        	int from = find(node.prev);
        	
        	if(!isSameParent(to, from)) {
        		total += node.weight;
        		union(node.to, node.prev);
        	}
        }
        
        System.out.println(total);
        
        
    }
    
    public static int find(int x) {
    	if(parents[x] == x) return x;
    	return parents[x] = find(parents[x]);
    }
    
    public static void union(int x, int y) {
    	x = find(x);
    	y = find(y);
    	if(x!=y) {
    		parents[y] = x;
    	}
    }
    
    public static boolean isSameParent(int x, int y) {
    	x = find(x);
    	y = find(y);
    	if(x==y) return true;
    	else return false;
    }
}
