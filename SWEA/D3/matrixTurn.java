import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class matrixTurn {

    public static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= test; test_case++){
            int N = Integer.parseInt(br.readLine());
            board = new int[N][N];

            for(int i = 0; i < N; i++){
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            String[] nine = getNineDegree();
            String[] eight = getEighteenDegree();
            String[] two = getTwentySevenDegree();

            System.out.printf("#%d\n", test_case);

            for(int i = 0; i < N; i++){
                System.out.printf("%s %s %s\n", nine[i], eight[i], two[i]);
            }

        }
    }
    public static String[] getNineDegree(){
        int size = board.length;
        int[][] newBoard = new int[size][size];
        String[] answer = new String[size];

        for(int i = 0; i < size; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < size; j++){
                newBoard[i][j] = board[size-1-j][i];
                sb.append(newBoard[i][j]);
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    public static String[] getEighteenDegree(){
        int size = board.length;
        int[][] newBoard = new int[size][size];
        String[] answer = new String[size];

        for(int i = 0; i < size; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < size; j++){
                newBoard[i][j] = board[size-1-i][size-1-j];
                sb.append(newBoard[i][j]);
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
    public static String[] getTwentySevenDegree(){
        int size = board.length;
        int[][] newBoard = new int[size][size];
        String[] answer = new String[size];


        for(int i = 0; i < size; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < size; j++){
                newBoard[i][j] = board[j][size-1-i];
                sb.append(newBoard[i][j]);
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}