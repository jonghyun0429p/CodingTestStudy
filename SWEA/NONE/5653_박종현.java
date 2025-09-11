import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Cell implements Comparable<Cell>{
		int x, y, left, energy;
		
		Cell(int x, int y, int left, int energy){
			this.x = x;
			this.y = y;
			this.left = left;
			this.energy = energy;
		}

		@Override
		public int compareTo(Cell o) {
			if(this.left == 0 && this.left == o.left) return o.energy - this.energy;
			return this.left - o.left;
		}
	}
	
	static int T, N, M, K;
	static PriorityQueue<Cell> q;
	static int[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	q = new PriorityQueue<>();
        	map = new int[350][350];
        	
        	int tempt;
        	for(int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < M; j++) {
        			tempt = Integer.parseInt(st.nextToken());
        			if(tempt != 0) {
        				q.add(new Cell(j+150, i+150, tempt, tempt));
        				map[i+150][j+150] = -1;
        			}
        		}
        	}
        	
        	PriorityQueue<Cell> temptQ;
        	Cell cur;
        	int x, y;
        	for(int i = 0; i < K; i++) {
        		temptQ = new PriorityQueue<>();
        		
        		while(!q.isEmpty()) {
        			cur = q.poll();
        			
        			if(cur.left == 0) {
        				for(int j = 0; j < 4; j++) {
        					x = cur.x + dx[j];
        					y = cur.y + dy[j];
        					
        					if(map[y][x] == 0) {
        						temptQ.add(new Cell(x, y, cur.energy, cur.energy));
        						map[y][x] = -1;
        					}        					
        				}
        			}        			
        			cur.left--;
        			if(cur.left + cur.energy == 0) continue;
        			temptQ.add(cur);
        		}
        		
        		q = temptQ;
        	}
        	
        	sb.append("#"+t+" "+q.size()+"\n");
        }
        System.out.println(sb.toString());
    }
}
