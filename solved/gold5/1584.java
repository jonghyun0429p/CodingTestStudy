import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	//이게 board를 500*500인데 영역에 대한 정보가 주어지면 어떻게 처리할지 고민 중임.
	//1. board를 직접 반영한다.
	//2. 영억을 따로 관리해서 반영한다.
	//1번이라면 영역마다 그 범위만큼 계속 접근함. 이론상 500번 수정이 들어감. 대신 움직일때 값을 쉽게 관리 가능함. 
	//2번이면 영역이 들어올때 그 값만 저장하면 되는거라서 수정이 적음. 대신 움직일때 영역이 많다면 비교를 엄청해야됨. 영역 100개. 비교를 100번을 이동마다 하면 100*500.
	
	//1번
//	static class Area{
//		int x1, y1, x2, y2;
//		
//		public Area(int x1, int y1, int x2, int y2) {
//			this.x1 = x1;
//			this.y1 = y1;
//			this.x2 = x2;
//			this.y2 = y2;
//		}
//		
//		public Area(int[] points) {
//			this.x1 = points[0];
//			this.y1 = points[1];
//			this.x2 = points[2];
//			this.y2 = points[3];
//		}
//	}	
//
//	static class Point implements Comparable<Point>{
//		int curX, curY, health;
//		
//		public Point(int curX, int curY, int health) {
//			this.curX = curX;
//			this.curY = curY;
//			this.health = health;
//		}
//	
//		@Override
//		public int compareTo(Point o) {
//			return this.health - o.health;
//		}
//	}
//
//	static final int max = 501;
//	static final int[] dx = {0, 1, 0, -1};
//	static final int[] dy = {-1, 0, 1, 0};
//	static PriorityQueue<Point> pq;
//	static int[][] board;
//	static int[] points;
//	static boolean[][] visited;
//	static Area area;
//	static int nx, ny;
//	
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		sb.append(-1);
//		
//		board = new int[max][max];
//		visited = new boolean[max][max];
//		int dangerCnt = Integer.parseInt(br.readLine());
//		
//		for(int i = 0; i < dangerCnt; i++) {
//			points = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//			//x2, y2가 x1, y1보다 크다는 조건.
//			if(points[2] - points[0] >= 0 && points[3] - points[1] >= 0) {
//				area = new Area(points[0], points[1], points[2], points[3]);
//			}else if(points[2] - points[0] <= 0 && points[3] - points[1] >= 0){
//				area = new Area(points[2], points[1], points[0], points[3]);
//			}else if(points[2] - points[0] <= 0 && points[3] - points[1] <= 0){
//				area = new Area(points[2], points[3], points[0], points[1]);				
//			}else {
//				area = new Area(points[0], points[3], points[2], points[1]);				
//			}
//			
//			for(int x = area.x1; x <= area.x2; x++) {
//				for(int y = area.y1; y <= area.y2; y++) {
//					if(board[y][x] == 0) {
//						board[y][x] = 1;
//					}
//				}
//			}
//		}
//		
//		int deathCnt = Integer.parseInt(br.readLine());
//		
//		for(int i = 0; i < deathCnt; i++) {
//			points = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//			//x2, y2가 x1, y1보다 크다는 조건.
//			if(points[2] - points[0] >= 0 && points[3] - points[1] >= 0) {
//				area = new Area(points[0], points[1], points[2], points[3]);
//			}else if(points[2] - points[0] <= 0 && points[3] - points[1] >= 0){
//				area = new Area(points[2], points[1], points[0], points[3]);
//			}else if(points[2] - points[0] <= 0 && points[3] - points[1] <= 0){
//				area = new Area(points[2], points[3], points[0], points[1]);				
//			}else {
//				area = new Area(points[0], points[3], points[2], points[1]);				
//			}
//			
//			for(int x = area.x1; x <= area.x2; x++) {
//				for(int y = area.y1; y <= area.y2; y++) {
//					if(board[y][x] != 2) {
//						board[y][x] = 2;
//					}
//				}
//			}
//		}
//		pq = new PriorityQueue<Point>();
//		
//		pq.add(new Point(0, 0, 0));
//		visited[0][0] = true;
//		Point pt;
//		
//		while(!pq.isEmpty()) {
//			pt = pq.poll();
//			if(pt.curX == 500 && pt.curY == 500) {
//				sb.setLength(0);
//				sb.append(pt.health);
//				break;
//			}
//			
//			for(int i = 0; i < 4; i++) {
//				nx = pt.curX + dx[i];
//				ny = pt.curY + dy[i];
//				
//				if(nx < 0 || ny < 0 || max <= nx || max <= ny) continue;
//				if(!visited[ny][nx]) {
//					visited[ny][nx] = true;
//					
//					if(board[ny][nx] == 0) {
//						pq.add(new Point(nx, ny, pt.health));
//					}else if(board[ny][nx] == 1) {
//						pq.add(new Point(nx, ny, pt.health+1));
//					}
//				}
//			}
//		}		
//		System.out.println(sb);
//	}
	
	//2번
	static class Area{
		int x1, y1, x2, y2;
		
		public Area(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
		
		public Area(int[] points) {
			this.x1 = points[0];
			this.y1 = points[1];
			this.x2 = points[2];
			this.y2 = points[3];
		}
	}
	
	static class Point implements Comparable<Point>{
		int curX, curY, health;
		
		public Point(int curX, int curY, int health) {
			this.curX = curX;
			this.curY = curY;
			this.health = health;
		}

		@Override
		public int compareTo(Point o) {
			return this.health - o.health;
		}
	}
	
	static final int max = 500;
	static final int[] dx = {0, 1, 0, -1};
	static final int[] dy = {-1, 0, 1, 0};
	static boolean danger, death;
	static int dangerCnt, deathCnt, x1, y1, x2, y2;
	static int[] points;
	static ArrayList<Area> DangerAreas;
	static ArrayList<Area> DeathAreas;
	static PriorityQueue<Point> pq;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append(-1);
		
		DangerAreas = new ArrayList<Area>();
		DeathAreas = new ArrayList<Area>();
		visited = new boolean[max+1][max+1];
		
		dangerCnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < dangerCnt; i++) {
			points = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			DangerAreas.add(new Area(points));			
		}
		
		deathCnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < deathCnt; i++) {
			points = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			DeathAreas.add(new Area(points));
		}
		
		pq = new PriorityQueue<Point>();
		pq.add(new Point(0, 0, 0));

		while(!pq.isEmpty()) {
			Point pt = pq.poll();
			danger = false;
			death = false;
			
			if(pt.curX == 500 && pt.curY == 500) {
				sb.setLength(0);
				sb.append(pt.health);
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = pt.curX + dx[i];
				int ny = pt.curY + dy[i];
				if(nx < 0 || ny < 0 || max < nx || max < ny) continue;
				if(!visited[ny][nx]) {
					visited[ny][nx] = true;
					
					for(Area a : DeathAreas) {
						x1 = a.x1;
						x2 = a.x2;
						y1 = a.y1;
						y2 = a.y2;
						if(x1 < x2 && y1 < y2) {
							if(x1 <= nx && nx <= x2 && y1 <= ny && ny <= y2) {
								death = true;
								break;
							}
						}else if(x2 < x1 && y1 < y2) {
							if(x2 <= nx && nx <= x1 && y1 <= ny && ny <= y2) {
								death = true;
								break;
							}
						}else if(x1 < x2 && y2 < y1) {
							if(x1 <= nx && nx <= x2 && y2 <= ny && ny <= y1) {
								death = true;
								break;
							}
						}else if(x1 < x2 && y2 < y1){
							if(x2 <= nx && nx <= x1 && y2 <= ny && ny <= y1) {
								death = true;
								break;
							}
						}
					}
					
					if(death) continue;
					
					for(Area a : DangerAreas) {
						x1 = a.x1;
						x2 = a.x2;
						y1 = a.y1;
						y2 = a.y2;
						if(x1 < x2 && y1 < y2) {
							if(x1 <= nx && nx <= x2 && y1 <= ny && ny <= y2) {
								danger = true;
								break;
							}
						}else if(x2 < x1 && y1 < y2) {
							if(x2 <= nx && nx <= x1 && y1 <= ny && ny <= y2) {
								danger = true;
								break;
							}
						}else if(x1 < x2 && y2 < y1) {
							if(x1 <= nx && nx <= x2 && y2 <= ny && ny <= y1) {
								danger = true;
								break;
							}
						}else if(x2 < x1 && y2 < y1){
							if(x2 <= nx && nx <= x1 && y2 <= ny && ny <= y1) {
								danger = true;
								break;
							}
						}
					}
					
					if(danger) {
						pq.add(new Point(nx, ny, pt.health+1));
					}else {
						pq.add(new Point(nx, ny, pt.health));
					}
				}
				
			}
		}
		System.out.println(sb);
	}
}
