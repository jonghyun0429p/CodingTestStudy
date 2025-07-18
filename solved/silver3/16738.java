import java.io.*;
import java.util.*;

public class Main {

    static int N, Q;
    static boolean[] occupied;
    static List<int[]> rooms = new ArrayList<>();
    // 각 room: [L, R, 사람 수, isUsed=1 or 0]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        occupied = new boolean[N + 2]; // 1-based

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("new")) {
                int people = Integer.parseInt(st.nextToken());
                int size = Integer.parseInt(st.nextToken());

                boolean found = false;
                for (int start = 1; start + size - 1 <= N; start++) {
                    boolean can = true;
                    for (int j = 0; j < size; j++) {
                        if (occupied[start + j]) {
                            can = false;
                            break;
                        }
                    }

                    if (can) {
                        for (int j = 0; j < size; j++) {
                            occupied[start + j] = true;
                        }
                        rooms.add(new int[]{start, start + size - 1, people, 1});
                        sb.append(start).append(" ").append(start + size - 1).append("\n");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    sb.append("REJECTED\n");
                }

            } else if (cmd.equals("in")) {
                int index = Integer.parseInt(st.nextToken()) - 1;
                int inPeople = Integer.parseInt(st.nextToken());

                if (rooms.get(index)[3] == 1) {
                    rooms.get(index)[2] += inPeople;
                }

            } else if (cmd.equals("out")) {
                int index = Integer.parseInt(st.nextToken()) - 1;
                int outPeople = Integer.parseInt(st.nextToken());

                int[] room = rooms.get(index);
                if (room[3] == 1) {
                    room[2] -= outPeople;
                    if (room[2] == 0) {
                        for (int j = room[0]; j <= room[1]; j++) {
                            occupied[j] = false;
                        }
                        room[3] = 0;
                        sb.append("CLEAN ").append(room[0]).append(" ").append(room[1]).append("\n");
                    }
                }
            }
        }

        System.out.print(sb);
    }
}