//DP
import java.io.*;
import java.util.*;

public class Main {

    static int RIGHT = 0;
    static int DIAGONAL = 1;
    static int DOWN = 2;
    static int[][] board;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        board = new int[size][size];
        int[][][] dp = new int[size][size][3];

        for(int i = 0; i < size; i++){
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        //start point is 1,2. end point is size, size. how to go end point. let's count the number of ways to move
        dp[0][1][RIGHT] = 1;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                for(int k = 0; k < 3; k++){
                    if(dp[i][j][k] > 0){
                        if(k == RIGHT){
                            if(canMove(i, j, RIGHT)){
                                dp[i][j+1][RIGHT] += dp[i][j][RIGHT];
                            }
                            if(canMove(i, j, DIAGONAL)){
                                dp[i+1][j+1][DIAGONAL] += dp[i][j][RIGHT];
                            }

                        }else if(k == DOWN){
                           if(canMove(i, j, DOWN)){
                               dp[i+1][j][DOWN] += dp[i][j][DOWN];
                           }
                           if(canMove(i, j, DIAGONAL)){
                               dp[i+1][j+1][DIAGONAL] += dp[i][j][DOWN];
                           }
                        }else{
                            if(canMove(i, j, DOWN)){
                                dp[i+1][j][DOWN] += dp[i][j][DIAGONAL];
                            }
                            if(canMove(i, j, RIGHT)){
                                dp[i][j+1][RIGHT] += dp[i][j][DIAGONAL];
                            }
                            if(canMove(i, j, DIAGONAL)){
                                dp[i+1][j+1][DIAGONAL] += dp[i][j][DIAGONAL];
                            }
                        }
                    }
                }
            }
        }

        System.out.println(dp[size-1][size-1][DOWN] + dp[size-1][size-1][RIGHT] + dp[size-1][size-1][DIAGONAL]);



    }

    public static boolean canMove(int col, int row, int arrow){
        int size = board.length;
        if(arrow == RIGHT){
            if(row+1 < size){
                if(board[col][row+1] == 0){
                    return true;
                }
            }
        }else if(arrow == DOWN){
            if(col+1 < size){
                if(board[col+1][row] == 0){
                    return true;
                }
            }
        }else if(arrow == DIAGONAL){
            if(row+1 < size && col+1 < size){
                if(board[col][row+1] == 0 && board[col+1][row] == 0 && board[col+1][row+1] == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
