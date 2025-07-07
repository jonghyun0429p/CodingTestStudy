import java.io.*;
import java.util.*;

public class Main {
    static String[] colors;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args)throws Exception {
        boolean isGreenRed = false;
        int sectionCount = 0;
        int sectionCountGreenRed = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        colors = new String[N];

        for(int i = 0; i < N; i++){
            colors[i] = br.readLine();
        }

        for(int k = 0; k < 2; k++){
            isGreenRed = !isGreenRed;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]){
                        visited[i][j] = true;
                        getSections(i, j, isGreenRed);
                        if(isGreenRed){
                            sectionCountGreenRed += 1;
                        }else {
                            sectionCount += 1;
                        }
                    }
                }
            }
        }
        System.out.println(sectionCount + " " + sectionCountGreenRed);
    }

    public static void getSections(int x, int y, boolean isGreenRed){
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {x, y});
        visited[x][y] = true;

        char color = colors[x].charAt(y);

        while(!que.isEmpty()){
            int[] point = que.poll();

            for(int i = 0; i < 4; i++){
                int nextX = point[0] + dx[i];
                int nextY = point[1] + dy[i];

                if(0 <= nextX && 0 <= nextY && nextX < colors.length && nextY < colors.length){
                    if(!visited[nextX][nextY]) {
                        char newColor = colors[nextX].charAt(nextY);
                        if (isSameColor(color, newColor, isGreenRed)) {
                            visited[nextX][nextY] = true;
                            que.offer(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }
    }

    public static boolean isSameColor(char color, char nextColor, boolean isGreenRed){
        if(isGreenRed){
            if(color == 'R' && nextColor == 'G'){
                return true;
            } else if (color == 'G' && nextColor == 'R') {
                return true;
            }
        }

        if(color == nextColor){
            return true;
        }

        return false;
    }
}