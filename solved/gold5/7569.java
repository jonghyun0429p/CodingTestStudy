import java.io.*;
import java.util.*;

public class Main {

    static int[][][] board;
    static int[][] dxyzs = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0},
                    {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static boolean[][][] visited;
    static Queue<int[]> que = new ArrayDeque<>();;
    static boolean checkZero = false;

    public static void checkOne(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                for(int k = 0; k < board[0][0].length; k++){
                    if(board[i][j][k] == 1){
                        que.offer(new int[]{i, j, k});
                    }else if(!checkZero && board[i][j][k] == 0){
                        checkZero = true;
                    }
                }
            }
        }
    }

    public static boolean checkZero(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                for(int k = 0; k < board[0][0].length; k++){
                    if(board[i][j][k] == 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static int bfs(){
        int day = -1;

        while(!que.isEmpty()){

            int size = que.size();
            day += 1;

            for(int i = 0; i < size; i++){
                int[] cur_zyx = que.poll();

                for(int[] dzyx : dxyzs){
                    int z = cur_zyx[0] + dzyx[0];
                    int y = cur_zyx[1] + dzyx[1];
                    int x = cur_zyx[2] + dzyx[2];

                    if(0 <= z && z < board.length && 0 <= y && y < board[0].length && 0 <= x && x < board[0][0].length){
                        if(board[z][y][x] == 0){
                            que.offer(new int[] {z, y, x});
                            board[z][y][x] = 1;
                        }
                    }
                }
            }

        }

        return day;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] sizes = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();

        board = new int[sizes[2]][sizes[1]][sizes[0]];
        visited = new boolean[sizes[2]][sizes[1]][sizes[0]];

        for(int i = 0; i < sizes[1] * sizes[2]; i++){
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            board[i/sizes[1]][i%sizes[1]] = line;
        }

        checkOne();

        if(!checkZero){
            System.out.println(0);
            return;
        }

        int day = bfs();

        if(checkZero()){
            System.out.println(-1);
        }else{
            System.out.println(day);
        }

    }
}
