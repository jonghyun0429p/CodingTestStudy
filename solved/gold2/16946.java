import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {-1, 0, 1, 0};

    static int N, M;
    static int[][] Board, Move, Answer;
    static boolean[][] visited;
    static ArrayList<Integer> GroupSize;

    static class Node {
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Board = new int[N][M];
        Move = new int[N][M];
        Answer = new int[N][M];
        visited = new boolean[N][M];

        GroupSize = new ArrayList<>();
        GroupSize.add(0);   // dummy index
        int GroupId = 1;

        // 입력
        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                Board[i][j] = arr[j] - '0';
            }
        }

        // 1️⃣ 0 영역 그룹화
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {

                if(Board[i][j] == 0 && !visited[i][j]) {

                    Queue<Node> q = new ArrayDeque<>();
                    q.add(new Node(j, i));
                    visited[i][j] = true;
                    Move[i][j] = GroupId;

                    int size = 1;

                    while(!q.isEmpty()) {
                        Node n = q.poll();

                        for(int d = 0; d < 4; d++) {
                            int nx = n.x + dx[d];
                            int ny = n.y + dy[d];

                            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                            if(Board[ny][nx] == 0 && !visited[ny][nx]) {
                                visited[ny][nx] = true;
                                Move[ny][nx] = GroupId;
                                q.add(new Node(nx, ny));
                                size++;
                            }
                        }
                    }

                    GroupSize.add(size);
                    GroupId++;
                }
            }
        }

        // 2️⃣ 벽 처리
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {

                if(Board[i][j] == 1) {

                    HashSet<Integer> set = new HashSet<>();

                    for(int d = 0; d < 4; d++) {
                        int nx = j + dx[d];
                        int ny = i + dy[d];

                        if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                        if(Board[ny][nx] == 0) {
                            set.add(Move[ny][nx]);
                        }
                    }

                    int sum = 1;

                    for(int id : set) {
                        sum += GroupSize.get(id);
                    }

                    Answer[i][j] = sum % 10;
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(Answer[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}