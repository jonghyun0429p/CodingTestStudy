import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = 1_000_000_000;
	static int V, E, P;
	static int[] Line;
	static int[][] dist;
	static ArrayList<Graph>[] Graphs;
	
	static class Graph{
		int next, dist;
		
		Graph(int next, int dist){
			this.next = next;
			this.dist = dist;
		}
	}
	
	//상태 관리를 다익스트라에서 하는게 맞나? 맞네
	//dist에서 상태가 true고 최소치랑 같은지 비교를 해야하는데;
	static class Node implements Comparable<Node>{
		int next, total;
		boolean isSave;
		
		Node(int next, int total, boolean isSave){
			this.next = next;
			this.total = total;
			this.isSave = isSave;
		}

		@Override
		public int compareTo(Node o) {
		    return Integer.compare(this.total, o.total);
		}
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        V = Line[0];
        E = Line[1];
        P = Line[2];
        
        Graphs = new ArrayList[V+1];
        dist = new int[V+1][2];
        
        for(int i = 1; i <= V; i++) {
        	dist[i][0] = INF;
        	dist[i][1] = INF;
        	Graphs[i] = new ArrayList<Graph>();
        }
        
        for(int i = 0; i < E; i++) {
        	Line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
        	Graphs[Line[0]].add(new Graph(Line[1], Line[2]));
        	Graphs[Line[1]].add(new Graph(Line[0], Line[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();

        if (P == 1) {
            dist[1][1] = 0;
            pq.add(new Node(1, 0, true));
        } else {
            dist[1][0] = 0;
            pq.add(new Node(1, 0, false));
        }
        
        dist[1][0] = 0;
        
        while(!pq.isEmpty()) {
        	Node n = pq.poll();
        	
        	int state = n.isSave ? 1 : 0;

        	if(dist[n.next][state] < n.total) continue;
        	
        	for(Graph g : Graphs[n.next]) {
        		int cur = g.dist + n.total;
        		
        		boolean nextSave = n.isSave || (g.next == P);
        		int nextState = nextSave ? 1 : 0;

        		if(dist[g.next][nextState] > cur) {
        		    dist[g.next][nextState] = cur;
        		    pq.add(new Node(g.next, cur, nextSave));
        		}
        	}
        }
        
        if(dist[V][1] <= dist[V][0]) {
        	System.out.println("SAVE HIM");
        }else {
        	System.out.println("GOOD BYE");
        }
    }
}