import java.io.*;
import java.util.*;

//다익스트라로 최단 거리를 구할 수 있는데,
//여기서 시간을 지연시키려면 여기에 해당되는 길을 하나씩 배제해봐야함;
//그러면 그 때마다 최단거리를 구해야하는데 이거 말이 안됨
//잘린 위치에서 다익스트라? 다를게 없는데? 저장해서 parent같은 방식으로 가면 길은 저장되는데
//visited나 Dist를 관리 해줘야지 이게 가능한데 관리하기도 애매함
//양방향이라 dist를 초기화하면 다 다시 구하는 거랑 다를게 없음
//지우고 둘 다 INF로 초기화만 하면? Dist보다 길어질테니까 값이 변화가 없을거임
//Dist 도착지도 INF로 하면? 가는길이 다 작아서 문제가 생길건데
//만약 1 2 3 4 5 9로 가는게 제일 빠르다면,
//4 5를 자른다고 하면 9에서 4로 가는 역방향으로 구하면 되지않으려나


//1초면 10억번
//한번 다익 돌리면 5000*log(1000) = 50000
public class Main {

	static final int INF = 1_000_000_000;
	static int N, M, A, B, T, MAX, DIF;
	static int[] newDist;
	static int[][] Dist;
	static ArrayList<Graph>[] Graphs;
	static PriorityQueue<Node> pq;
	
	static class Graph{
		int next, dist;
		
		Graph(int next, int dist){
			this.next = next;
			this.dist = dist;
		}
	}
	
	static class Node implements Comparable<Node>{
		int next, total;
		
		Node(int next, int total){
			this.next = next;
			this.total = total;
		}

		@Override
		public int compareTo(Node o) {
			return this.total - o.total;
		}
	}

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        Dist = new int[N+1][2];
        newDist = new int[N+1];
        Graphs = new ArrayList[N+1];
        
        for(int i = 1; i <= N; i++) {
        	Dist[i][0] = INF;
        	Dist[i][1] = i;
        	Graphs[i] = new ArrayList<Graph>();
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	A = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());
        	T = Integer.parseInt(st.nextToken());
        	
        	Graphs[A].add(new Graph(B, T));
        	Graphs[B].add(new Graph(A, T));
        }
        
        pq = new PriorityQueue<Node>();
        
        for(int i = 1; i <= N; i++) {
        	Dist[i][0] = INF;
        }
        
        pq = new PriorityQueue<Node>();
        
        pq.add(new Node(1, 0));
        Dist[1][0] = 0;
        
        while(!pq.isEmpty()) {
        	Node n = pq.poll();
        	
        	if(n.next == N) break;
        	
        	for(Graph g : Graphs[n.next]) {        		
        		int cur = g.dist + n.total;
        		
        		if(Dist[g.next][0] > cur) {
        			Dist[g.next][0] = cur;
        			Dist[g.next][1] = n.next;
        			pq.add(new Node(g.next, cur));
        		}
        	}        	
        }
        
//        for(int i = 1; i <= N; i++) {
//        	System.out.println(Dist[i][0] + " " + Dist[i][1]);
//        }
        
        MAX = Dist[N][0];
        int cur = N;
        int dist;
        
        while(cur != 1){
        	getDist(cur, Dist[cur][1]);
        	cur = Dist[cur][1];
        	
        	dist = newDist[N];
        	
        	if(dist == INF) {
        		DIF = INF;
        		break;
        	}
        	
        	DIF = Math.max(DIF, dist - MAX);
        }
        
        if(DIF == INF) {
            System.out.println(-1);        	
        }else {
            System.out.println(DIF);        	
        }
    }
    
    static void getDist(int cutFir, int cutSec) {
    	
        for(int i = 1; i <= N; i++) {
        	newDist[i] = INF;
        }
        
        pq = new PriorityQueue<Node>();
        
        pq.add(new Node(1, 0));
        newDist[1] = 0;
        
        while(!pq.isEmpty()) {
        	Node n = pq.poll();
        	
        	if(n.next == N) break;
        	
        	for(Graph g : Graphs[n.next]) {
        		
        		if(g.next == cutFir && n.next == cutSec) continue;
        		if(n.next == cutFir && g.next == cutSec) continue;
        		
        		int cur = g.dist + n.total;
        		
        		if(newDist[g.next] > cur) {
        			newDist[g.next] = cur;
        			
        			pq.add(new Node(g.next, cur));
        		}
        	}       
        }
    }
}