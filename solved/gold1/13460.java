import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	//사이즈 N*M 빨간 구슬을 구멍에 넣고 파란 구슬은 구멍에 넣으면 안된다. 두 개가 동시에 빠져도 실패
	//중력으로 기울이기 상하좌우 이동 가능 끝까지 가버림;
	//첫 줄 N M
	//M개의 문자열 N번 입력
	//R 빨간 공, B 파란 공, O 구멍, . 빈칸, # 벽
	//10번 이하로 못 꺼내면 -1 출력

	//생각한 풀이는 bfs를 활용해서 원래 이동할 상태 저장하고, 상 하 좌 우 각각 적용하면 이동하지 않았다면 다음 상태로 넘기지 않고
	//이동했다면 다음 상태로 넘기기.
	//반복되는 행동에 대해 시간을 낭비시키지 않으려면 visited를 활용해서 멈추게 만듬.

	static char[][] board;
	static boolean[][] visited;
	static int[] RedPoint;
	static int[] BluePoint;
	static int[] hole;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		board = new char[N][M];
		visited = new boolean[N][M];

		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				char cur = line.charAt(j);
				board[i][j] = cur;
				if(cur == 'R') {
					RedPoint = new int[] {j, i};
				}else if(cur == 'B') {
					BluePoint = new int[] {j, i};
				}else if(cur == 'O') {
					hole = new int[] {j, i};
				}
			}
		}
		System.out.println("빨간 공 위치 " + RedPoint[0] + RedPoint[1]);
		System.out.println("파란 공 위치 " + BluePoint[0] + BluePoint[1]);
		System.out.println("구멍 위치 " + hole[0] + hole[1]);

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {RedPoint[0], RedPoint[1], 0});
		visited[RedPoint[0]][RedPoint[1]] = true;

		while(!q.isEmpty()) {
			System.out.println("bfs 탈출 중");
			int[] cur = q.poll();

			if(cur[2] > 9) {
				break;
			}

			for(int i = 0; i < 4; i++) {
				int newX = cur[0] + dx[i];
				int newY = cur[1] + dy[i];
				//상하좌우를 찾고 이동하는 과정에서, 각 이동한 위치가 visited가 되어있는지 구하려면 이건 구한 과정에서 쓰는게나은데
				//덜 이동해서 저장되는게 더 좋다면 visited를 boolean말고 그냥 int로 해서 관리하는게 나을지 고민
				if(0 < newX && 0 < newY && newX < board[0].length-1 && newY<board.length-1 && board[newY][newX] != '#') {
					int[] newPoint = move(cur[0], cur[1], i);
					if (newX == hole[0] && newY == hole[1]) {
					    return cur[2]+1;
					}
					visited[newPoint[0]][newPoint[1]] = true;
					q.add(new int[] {newPoint[0], newPoint[1], cur[2]+1});
				}
			}
		}
		return -1;
	}


	static int[] move(int x, int y, int way) {
		int newX = x+dx[way];
		int newY = y+dy[way];
		while(true) {
			System.out.println("좌표"+newX+newY);
			if(0<newX && 0<newY && newX < board[0].length-1 && newY<board.length-1) {
				System.out.println("범위 안 임");
				char pointValue = board[newY][newX];
				if(pointValue != '#' && pointValue != 'B') {
					if(pointValue == 'O') {
						break;
					}
					newX = newX+dx[way];
					newY = newY+dy[way];
				}else {
					break;
				}
			}else {
				break;
			}
		}
		return new int[] {newX, newY};
	}

}
