import java.util.Scanner;

public class Solution {

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class PointPair {
        int x1, y1, x2, y2;
        public PointPair(Point p1, Point p2) {
            this.x1 = p1.x;
            this.y1 = p1.y;
            this.x2 = p2.x;
            this.y2 = p2.y;
        }

        public Point getOtherPoint(int x, int y) {
            if (x1 == x && y1 == y) return new Point(x2, y2);
            if (x2 == x && y2 == y) return new Point(x1, y1);
            return null;
        }
    }

    static int[][] board;
    static PointPair[] warmholePair;
    static Point[] warmholes;
    static int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int answer = 0;

            board = new int[N][N];
            warmholePair = new PointPair[5];
            warmholes = new Point[5];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                    int cur = board[i][j];
                    if (cur > 5) {
                        if (warmholes[cur - 6] == null) {
                            warmholes[cur - 6] = new Point(j, i);
                        } else {
                            warmholePair[cur - 6] = new PointPair(warmholes[cur - 6], new Point(j, i));
                        }
                    }
                }
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (board[y][x] == 0) {
                        answer = Math.max(answer, getPoint(new Point(x, y)));
                    }
                }
            }

            System.out.printf("#%d %d\n", test_case, answer);
        }

        sc.close();
    }

    static int getPoint(Point start) {
        int maxValue = 0;

        for (int dir = 0; dir < 4; dir++) {
            int x = start.x;
            int y = start.y;
            int d = dir;
            int count = 0;
            boolean first = true;

            while (true) {
                x += dx[d];
                y += dy[d];

                if (!first && x == start.x && y == start.y) break;
                first = false;

                if (x < 0 || y < 0 || x >= board.length || y >= board.length) {
                    d = getReturn(d);
                    count++;
                    continue;
                }

                int val = board[y][x];
                if (val == -1) break;

                if (val >= 6) {
                    Point p = warmholePair[val - 6].getOtherPoint(x, y);
                    x = p.x;
                    y = p.y;
                    if (x == start.x && y == start.y) break;
                    continue;
                }

                if (val >= 1 && val <= 5) {
                    d = getBallMovingDirection(val, d);
                    count++;
                }
            }

            maxValue = Math.max(maxValue, count);
        }

        return maxValue;
    }

    static int getBallMovingDirection(int block, int dir) {
        if (dir == 0) {
            if (block == 2) return 3;
            if (block == 3) return 2;
        } else if (dir == 1) {
            if (block == 1) return 3;
            if (block == 4) return 2;
        } else if (dir == 2) {
            if (block == 1) return 0;
            if (block == 2) return 1;
        } else if (dir == 3) {
            if (block == 3) return 1;
            if (block == 4) return 0;
        }
        return getReturn(dir); // 공통 처리: 나머지는 전부 반사
    }

    static int getReturn(int dir) {
        if (dir == 0) return 1;
        if (dir == 1) return 0;
        if (dir == 2) return 3;
        return 2;
    }
}