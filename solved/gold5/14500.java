import java.io.*;
import java.util.*;
import java.util.jar.JarEntry;

public class Main {

    static int[][] board;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = NM[0];
        int M = NM[1];

        board = new int[N][M];
        int maxSum = 0;

        for(int i = 0; i < N; i++){
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                maxSum = Math.max(maxSum, getTetromino(i, j));
            }
        }
        System.out.printf("%d\n", maxSum);
    }

    public static int getTetromino(int i, int j){
        int maxSum = 0;
        int rowSize = board[0].length;
        int colSize = board.length;

        //4칸짜리 막대기 구현
        //ㅡ
        if(j + 3 < rowSize){
            maxSum = Math.max(maxSum, board[i][j] + board[i][j+1] + board[i][j+2] + board[i][j+3]);
        }
        //ㅣ
        if(i + 3 < colSize){
            maxSum = Math.max(maxSum, board[i][j] + board[i+1][j] + board[i+2][j] + board[i+3][j]);
        }

        //L모양, z모양 구현
        if(i + 2 < colSize && j + 1 < rowSize){
            maxSum = Math.max(maxSum, board[i][j] + board[i+1][j] + board[i+2][j] + board[i+2][j+1]);
            maxSum = Math.max(maxSum, board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+2][j+1]);
        }

        //L 90도
        if(0 <= i - 1 && j + 2 < rowSize){
            maxSum = Math.max(maxSum, board[i][j] + board[i][j+1] + board[i-1][j+2] + board[i][j+2]);
        }

        //L 180도
        if(0 <= i - 2 && 0 <= j - 1){
            maxSum = Math.max(maxSum, board[i][j] + board[i-1][j] + board[i-2][j] + board[i-2][j-1]);
        }

        //L 270도
        if(i + 1 < colSize && 0 <= j - 2){
            maxSum = Math.max(maxSum, board[i][j] + board[i][j-1] + board[i][j-2] + board[i+1][j-2]);
        }

        //Z 90도
        if(0 <= i - 1 && j + 2 < rowSize){
            maxSum = Math.max(maxSum, board[i][j] + board[i][j+1] + board[i-1][j+1] + board[i-1][j+2]);
        }

        //Z 180도
        if(0 <= i - 2 && 0 <= j - 1){
            maxSum = Math.max(maxSum, board[i][j] + board[i-1][j] + board[i-1][j-1] + board[i-2][j-1]);
        }

        //Z 270도
        if(i + 1 < colSize && 0 <= j - 2){
            maxSum = Math.max(maxSum, board[i][j] + board[i][j-1] + board[i+1][j-1] + board[i+1][j-2]);
        }

        //정사각형 모양
        if(i + 1 < colSize && j + 1 < rowSize){
            maxSum = Math.max(maxSum, board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i][j+1]);
        }

        //ㅜ모양
        if(i + 1 < colSize && j + 2 < rowSize){
            maxSum = Math.max(maxSum, board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i][j+2]);
        }

        //ㅜ 90도
        if(0 <= i - 2 && j + 1 < rowSize){
            maxSum = Math.max(maxSum, board[i][j] + board[i-1][j] + board[i-1][j+1] + board[i-2][j]);
        }

        //ㅜ 180도
        if(0 <= i - 1 && 0 <= j - 2){
            maxSum = Math.max(maxSum, board[i][j] + board[i][j-1] + board[i][j-2] + board[i-1][j-1]);
        }
        //ㅜ 270도
        if(i + 2 < colSize && 0 <= j - 1){
            maxSum = Math.max(maxSum, board[i][j] + board[i+1][j] + board[i+2][j] + board[i+1][j-1]);
        }

        return maxSum;
    }
}