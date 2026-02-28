import java.io.*;
import java.util.*;

//한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값을 구하는 프로그램
//작으면 continue시키고 크면 그걸 저장하는 방식으로 가면 될 듯 함.
//total 보다는 max가 좋지않을까.
//정렬은 큰 순으로, 

public class Main {
	
	static class Graph{
		int next, weight;
		
		Graph(int next, int weight){
			this.next = next;
			this.weight = weight;
		}
	}
	
	static class Node implements Comparable<Node>{
		int next, max;
		
		Node(int next, int max){
			this.next = next;
			this.max = max;
		}

		@Override
		public int compareTo(Node o) {
			return o.max - this.max;
		}
	}

	static int N, M, A, B, C;
	static int[] List, Dist;
	static ArrayList<Graph>[] Graphs;
	static PriorityQueue<Node> PQ;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        N = List[0];
        M = List[1];
        
        Dist = new int[N+1];
        Graphs = new ArrayList[N+1];
        PQ = new PriorityQueue<Node>();
        
        for(int i = 1; i <= N; i++) {
        	Dist[i] = 0;
        	Graphs[i] = new ArrayList<Graph>();
        }
        
        for(int i = 0; i < M; i++) {
        	List = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	
        	Graphs[List[0]].add(new Graph(List[1], List[2]));
        	Graphs[List[1]].add(new Graph(List[0], List[2]));
        }
        
        List = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        for(Graph g : Graphs[List[0]]) {
        	PQ.add(new Node(g.next, g.weight));
        	Dist[g.next] = g.weight;
        }
        
        while(!PQ.isEmpty()) {
        	Node n = PQ.poll();
    		
        	if(n.next == List[1]) {
        		System.out.println(n.max);
        		break;
        	}
        	
        	for(Graph g : Graphs[n.next]) {        		
        		if(Dist[g.next] >= Math.min(n.max, g.weight)) continue;
        		Dist[g.next] = Math.min(n.max, g.weight);
        		PQ.add(new Node(g.next, n.max));
        	}
        }
    }
}
