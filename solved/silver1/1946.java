import java.io.*;
import java.util.*;

public class Main {

    static int T, N, min;
    static int[][] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < T; test_case++){
            int count = 0;
            N = Integer.parseInt(br.readLine());

            people = new int[N][2];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 2; j++){
                    people[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            Arrays.sort(people, (a, b) -> a[0] - b[0]);

            min = people[0][1];
            count = 1; // 첫 번째 사람은 무조건 뽑힘

            for (int i = 1; i < N; i++) {
                if (people[i][1] < min) {
                    count++;
                    min = people[i][1]; // 갱신이 꼭 필요함!!
                }
            }

            System.out.println(count);
        }

    }
}
