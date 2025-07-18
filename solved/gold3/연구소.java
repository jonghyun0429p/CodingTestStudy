package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution {

	//일단 0을 저장하고, 거기서 3개를 고르는 조합으로 사용해서, 그 해당하는 값을 1로 바꾸는 함수하나
	//반복을 하면 바이러스가 퍼질거고, 변경점이 없을때까지 반복을 시키고, 결과로 남는 곳을 구하는 것.
	//그러면 일단 8x8까지 가능.2의 개수(바이러스)는 최소 2개, 그러면 이론상 최대 빈공간은 64-2
	//그러면 62C3 = 37820개의 조합이 나옴.
	//바이러스 한번 사이클 돌리면  bfs니까 최악 35번 64*35이면 2240
	//그러면 40,000*2,000 = 80,000,000 약 8천만개 여유가 있음.

	static int[][] board;
	static int[][] changeBoard;
	static List<int[]> emptys;
	static List<int[]> virus;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    	int N = NM[0];
    	int M = NM[1];

    	board = new int[N][M];
    	emptys = new ArrayList<>();
    	virus = new ArrayList<>();
    	//데이터를 입력받으면서 빈공간, 바이러스 기록
    	for(int i = 0; i < N; i++) {
    		int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    		board[i] = line;
    		for(int j = 0; j < M; j++) {
    			if(line[j] == 0) {
    				emptys.add(new int[] {i, j});
    			}else if(line[j] == 2) {
    				virus.add(new int[] {i, j});
    			}
    		}
    	}
    	System.out.println(Backtracking(0, 0, new ArrayList<>()));

    }

    static int Backtracking(int start, int depth, List<int[]> chooseWall){

    	int max_value = 0;

    	if(depth == 3) {
    		return getSafetyArea(chooseWall);
    	}

    	for(int i = start; i < emptys.size(); i++) {
    		chooseWall.add(emptys.get(i));
    		max_value = Math.max(max_value, Backtracking(i+1, depth+1, chooseWall));
    		chooseWall.remove(chooseWall.size()-1);
    	}

    	return max_value;
    }

    static int getSafetyArea(List<int[]> chooseWall) {

    	changeBoard = new int[board.length][];
    	for(int i = 0; i < board.length; i++) {
    		changeBoard[i] = board[i].clone();
    	}

    	for(int[] point : chooseWall) {
    		changeBoard[point[0]][point[1]] = 1;
    	}

    	return bfs();
    }

    static int bfs() {
    	int count = 0;
    	Queue<int[]> q = new ArrayDeque<>();
    	for(int i = 0; i < virus.size(); i++) {
    		q.add(virus.get(i));
    	}

    	while(!q.isEmpty()) {
    		 int[] cur = q.poll();

    		 for(int i = 0; i < 4; i++) {
    			 int curX = cur[1] + dx[i];
    			 int curY = cur[0] + dy[i];

    			 if(0 <= curX && curX < board[0].length && 0 <= curY && curY < board.length) {
    				 if(changeBoard[curY][curX] == 0) {
    					 changeBoard[curY][curX] = 2;
    					 q.add(new int[] {curY, curX});
    				 }
    			 }
    		 }
    	}

    	for(int i = 0; i < board.length; i++) {
    		for(int j = 0; j< board[0].length; j++) {
    			if(changeBoard[i][j] == 0) {
    				count += 1;
    			}
    		}
    	}

    	return count;
    }

}