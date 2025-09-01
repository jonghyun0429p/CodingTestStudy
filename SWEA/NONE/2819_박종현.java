import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static int T;
    static char[] board;
    static Set<String> s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            board = new char[16]; // 1D 배열로 처리 (4x4 크기)
            s = new HashSet<>();


            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    board[i * 4 + j] = st.nextToken().charAt(0); // 1D 배열로 저장
                }
            }


            for (int i = 0; i < 16; i++) {
                backTracking(i, 0, ""); // 각 칸에서 시작
            }

            
            System.out.println("#" + tc + " " + s.size());
        }
    }

    
    static void backTracking(int idx, int count, String num) {
        
        if (count == 7) {
            s.add(num);
            return;
        }

        
        num += board[idx];

       
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        int x = idx / 4;
        int y = idx % 4;


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];


            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                int nextIdx = nx * 4 + ny; // 새로 계산된 (nx, ny)에 해당하는 인덱스
                backTracking(nextIdx, count + 1, num);
            }
        }
    }
}
