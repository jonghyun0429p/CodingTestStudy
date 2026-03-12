import java.util.*;
import java.io.*;

//상태를 다 관리해줘야 하는데, 그냥 언제 켜지는지 알고 있으면 + 지금 시간 정보해서 구하기?
//그래프에 시간 값을 저장하기?
//아 사이클이라는게 어짜피 그래프 수를 말하는 듯
//Node에 위치, 이동 거리, 시간 이렇게 관리해주면 될 듯
//시간을 M으로 나눠서 그래프로 찾으면 될 듯
//지금 Dist는 원래 거리로 구분하는 거였는데 최소 시간으로 하려면 Dist를 최소 시간으로
//근데 이동을 안하고 다른걸 기다릴 수 있는거 아닌가? 이러면 어떻게 해야하지
//그냥 Dist는 모르겠고 pq에 또 넣어둬야하는건데 그냥 그 자리에 시간++ 해서

public class Main{

	static final long INF = Long.MAX_VALUE;
	static int N, M, A, B;
	static long[] Dist;
	static ArrayList<Graph>[] Graphs;
	
	static class Graph{
		int next, time;
		
		Graph(int next, int time){
			this.next = next;
			this.time = time;
		}
	}
	
	static class Node implements Comparable<Node>{
		int next;
		long time;
		
		Node(int next, long time){
			this.next = next;
			this.time = time;
		}

		@Override
		public int compareTo(Main.Node o) {
			return Long.compare(this.time, o.time);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Dist = new long[N+1];
		Graphs = new ArrayList[N+1];
		
		Arrays.fill(Dist, INF);
		for(int i = 1; i <= N; i++) {
			Graphs[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			Graphs[A].add(new Graph(B, i));
			Graphs[B].add(new Graph(A, i));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		pq.add(new Node(1, 0));
		Dist[1] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if (n.time > Dist[n.next]) continue;
			if(n.next == N) break;
			
			for(Graph g : Graphs[n.next]) {
				int signalStart = g.time - 1;
				long waitTime = (signalStart - (n.time % M) + M) % M;
				long nextTime = n.time + waitTime + 1;
				
				if(Dist[g.next] > nextTime) {
		            Dist[g.next] = nextTime;
		            pq.add(new Node(g.next, nextTime));
		        }
			}
		}				
		System.out.println(Dist[N]);	
	}
}