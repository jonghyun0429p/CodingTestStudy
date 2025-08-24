import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int T, N, max, min;
    static int[][] board;
    static List<int[]> list;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	min = Integer.MAX_VALUE;
        	max = 0;
        	list = new ArrayList<>();
        	board = new int[N][N];

        	for(int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < N; j++) {
        			board[i][j] = Integer.parseInt(st.nextToken());
        			if(0 < i && 0 < j && i < N && j < N && board[i][j] == 1) {
        				list.add(new int[] {j, i});
        			}
        		}
        	}
        	go(0, 0, 0);
        	System.out.printf("#%d %d\n", tc, min);
        }
    }

    static void go(int index, int cCnt, int lCnt) {

    	if(list.size() - index + cCnt < max) return;

    	if(index == list.size()) {
    		if(max < cCnt) {
    			max = cCnt;
    			min = lCnt;
    		}else if(max == cCnt) {
    			min = Math.min(min, lCnt);
    		}
    		return;
    	}

    	int[] cur = list.get(index);
    	int x = cur[0];
    	int y = cur[1];

    	for(int d = 0; d < 4; d++) {
    		if(!isAvailable(x, y, d)) continue;
    		int len = setStatus(x, y, d, 2);
    		go(index+1, cCnt+1, lCnt + len);
    		setStatus(x, y, d, 0);
    	}

    	go(index+1, cCnt, lCnt);
    }

    static boolean isAvailable(int x, int y, int d) {
    	int nx = x, ny = y;
    	while(true) {
    		nx += dx[d];
    		ny += dy[d];

    		if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
    		if(board[ny][nx] > 0) return false;
    	}
    	return true;
    }

    static int setStatus(int x, int y, int d, int g) {
    	int lengthSum = 0;
    	int nx = x, ny = y;

    	while(true){
    		nx += dx[d];
    		ny += dy[d];

    		if(nx < 0 || nx >= N || ny < 0 || ny>= N) break;
    		board[ny][nx] = g;

    		lengthSum++;
    	}
    	return lengthSum;
    }
}
