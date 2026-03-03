import java.io.*;
import java.util.*;

//최소 쓰레기 통과&근처 통과 횟수 구하기.
//다익스트라를 이용해서 Dist를 구해서 최단 거리를 구하는 것이 맞는 것 같음.
//그 과정에서 상태를 관리해야하는데, Dist[50][50]으로 거리를 관리할 수 있는데
//쓰레기통을 지나갔는지, 근처를 지나갔는지를 관리해야하는데, Dist를 4차원으로?
//Dist[50][50][2500][2500] 2500*2500*2500 너무 큼;
//그 위치로 이동하는데 지나간 것만 해서 최선을 저장해두면 될듯
//int[][] trash, int[][] near 이렇게 두 개?

public class Main {

	static final int INF = 1_000_000_000;
	static final int[] dx = {0, 1, 0, -1};
	static final int[] dy = {-1, 0, 1, 0};
	static int[][] trash, near;
	static char[][] board;
	static int M, N;
	
	static class Node implements Comparable<Node>{
		int x, y, trash, near;
		
		Node(int x, int y, int trash, int near){
			this.x = x;
			this.y = y;
			this.trash = trash;
			this.near = near;
		}

		@Override
		public int compareTo(Node o) {
			if(this.trash == o.trash) {
				return this.near - o.near;
			}else {
				return this.trash - o.trash;
			}
		}
	}

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        String line;
        int startX = 0;
        int startY = 0;
        char now;
        
        trash = new int[N][M];
        near = new int[N][M];
        board = new char[N][M];
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++) {
        	line = br.readLine();
        	for(int j = 0; j < M; j++) {
        		now = line.charAt(j);
        		board[i][j] = now;
        		trash[i][j] = INF;
        		near[i][j] = INF;
        		
        		if(now == 'S') {
        			startX = j;
        			startY = i;
        			trash[i][j] = 0;
        			near[i][j] = 0;
        		}
        	}
        }
        
        pq.add(new Node(startX, startY, 0, 0));
        
        while(!pq.isEmpty()) {
        	Node n = pq.poll();
        	
        	if(n.trash > trash[n.y][n.x]) continue;
        	if(n.trash == trash[n.y][n.x] && n.near > near[n.y][n.x]) continue;
        	
        	if(board[n.y][n.x] == 'F' ) {
        		System.out.println(trash[n.y][n.x] + " " + near[n.y][n.x]);
        		break;
        	}
        	
        	for(int i = 0; i < 4; i++) {
        		int nx = n.x + dx[i];
        		int ny = n.y + dy[i];
        		int nT = n.trash;
        		int nN = n.near;
        		
        		if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
        		
        		if(board[ny][nx] == 'g') nT++;
        		else if(board[ny][nx] != 'F'){
            		for(int d = 0; d < 4; d++) {
            			int tx = nx + dx[d];
            			int ty = ny + dy[d];
            			
            			if(tx < 0 || ty < 0 || tx >= M || ty >= N) continue;
            			if(board[ty][tx] == 'g') {
            				nN++;
            				break;
            			}
            		}
        		} 
        		
        		if(trash[ny][nx] > nT) {
        			trash[ny][nx] = nT;
        			near[ny][nx] = nN;
        			pq.add(new Node(nx, ny, nT, nN));
        		}else if(trash[ny][nx] == nT && near[ny][nx] > nN){
        			near[ny][nx] = nN;     
        			pq.add(new Node(nx, ny, nT, nN));   			
        		}
        	}
        }
    }
}