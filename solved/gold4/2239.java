import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] board;
	static boolean print;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s;
        
        print = false;
        board = new int[9][9];
        
        for(int i = 0; i < 9; i++) {
        	s = br.readLine();
        	
        	for(int j = 0; j < 9; j++) {
        		board[i][j] = s.charAt(j) - '0';
        	}
        }
        backtracking(0, 0);
        
    }
    public static void backtracking(int x, int y) {
//    	System.out.println(x+" "+y+" "+board[y][x]);
    	if(print) return;
    	if(board[y][x] == 0) {
    		for(int i = 1; i <= 9; i++) {
//    			System.out.println(i + " " + checkRight(x, y, i));
    			if(checkRight(x, y, i)) {
    				board[y][x] = i;
    				if(x == 8 && y == 8) {
    					printBoard();
    					print = true;
    					break;
    				}else if(x == 8) {
    					backtracking(0, y+1);
    				}else {
    					backtracking(x+1, y);
    				}
    				board[y][x] = 0;
    			}
    		}
    	}else {
			if(x == 8 && y == 8) {
				printBoard();
				print = true;
			}else if(x == 8) {
				backtracking(0, y+1);
			}else {
				backtracking(x+1, y);
			}
    	}
    }
    
    public static boolean checkRight(int x, int y, int value) {    	
    	for(int i = 0; i < 9; i++) {
    		if(board[i][x] == value || board[y][i] == value) {
        		return false;
        	}
    	}
    	
    	int startX = x/3;
    	startX *= 3;
    	int startY = y/3;
    	startY *= 3;
    	
    	for(int i = 0; i < 3; i++) {
    		if(board[startY+i][startX] == value || board[startY][startX+i] == value) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void printBoard() {
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    			System.out.print(board[i][j]);
    		}
    		System.out.println();
    	}
    }
    
}
