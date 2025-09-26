import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static LinkedList<int[]> deleteList;
	static int[][] board;
	static boolean[][] visited;
	static final int[] dx = {0, 0, -1, 1};
	static final int[] dy = {-1, 1, 0, 0};
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	deleteList = new LinkedList<>();
    	board = new int[N][M];
    	visited = new boolean[N][M];
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < M; j++) {
    			board[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	System.out.println(getTime());    	
    }
    
    public static int getTime() {
    	int count = 0;
    	
    	while(true) {
    		bfs();
    		if(deleteList.size() == 0) break;
    		deleteCheese();
    		count += 1;
    		cheeseChange();
    	}
    	return count;    	
    }
    
    public static void bfs() {
    	int[] point;
    	int nextX, nextY;
    	Queue<int[]> q = new ArrayDeque<>();
    	visited = new boolean[N][M];
    	q.add(new int[] {0,0});
    	visited[0][0] = true;
    	
    	while(!q.isEmpty()) {
    		point = q.poll();
    		
    		for(int i = 0; i < 4; i++) {
    			nextX = point[0] + dx[i];
    			nextY = point[1] + dy[i];
    			
    			if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
    			if(board[nextY][nextX] > 0) {
    				board[nextY][nextX] += 1;
    				if(board[nextY][nextX] == 3) {
    					deleteList.add(new int[] {nextX, nextY});
    				}
    				visited[nextY][nextX] = true;
    			}else if(!visited[nextY][nextX] && board[nextY][nextX] == 0) {
    				q.add(new int[] {nextX, nextY});
    				visited[nextY][nextX] = true;
    			}
    		}
    	}
    }
    
    public static void deleteCheese() {
    	int size = deleteList.size();
    	int[] point;
    	for(int i = 0; i < size; i++) {
    		point = deleteList.poll();
    		
    		board[point[1]][point[0]] = 0;
    	}
    }
    
    public static void cheeseChange() {
    	for(int i = 0; i < board.length; i++) {
    		for(int j = 0; j < board[0].length; j++) {
    			if(board[i][j] > 1) {
    				board[i][j] = 1;
    			}
    		}
    	}
    }
}
