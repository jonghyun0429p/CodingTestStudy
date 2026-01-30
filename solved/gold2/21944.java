import java.io.*;
import java.util.*;

public class Main {

    static class Info {
        int num;    // 문제 번호
        int dif;    // 난이도
        int group;  // 알고리즘 분류

        Info(int num, int dif, int group) {
            this.num = num;
            this.dif = dif;
            this.group = group;
        }
    }

    // 난이도 ↑, 문제번호 ↑
    static final Comparator<Info> COMP = (a, b) -> {
        if (a.dif != b.dif) return a.dif - b.dif;
        return a.num - b.num;
    };

    // 전체 문제
    static TreeSet<Info> all = new TreeSet<>(COMP);
    // 그룹별 문제
    static Map<Integer, TreeSet<Info>> byGroup = new HashMap<>();
    // 문제 번호 → Info (삭제용)
    static Map<Integer, Info> byNum = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 초기 문제 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            Info info = new Info(P, L, G);
            addInfo(info);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {

                case "add": {
                    int P = Integer.parseInt(st.nextToken());
                    int L = Integer.parseInt(st.nextToken());
                    int G = Integer.parseInt(st.nextToken());

                    addInfo(new Info(P, L, G));
                    break;
                }

                case "solved": {
                    int P = Integer.parseInt(st.nextToken());
                    Info info = byNum.remove(P);

                    all.remove(info);
                    byGroup.get(info.group).remove(info);
                    break;
                }

                case "recommend": {
                    int G = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());

                    TreeSet<Info> set = byGroup.get(G);
                    if (x == 1) sb.append(set.last().num);
                    else sb.append(set.first().num);
                    sb.append('\n');
                    break;
                }

                case "recommend2": {
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 1) sb.append(all.last().num);
                    else sb.append(all.first().num);
                    sb.append('\n');
                    break;
                }

                case "recommend3": {
                    int x = Integer.parseInt(st.nextToken());
                    int L = Integer.parseInt(st.nextToken());

                    Info res;
                    if (x == 1) {
                        // dif >= L 중 가장 쉬운
                        res = all.ceiling(new Info(0, L, 0));
                    } else {
                        // dif < L 중 가장 어려운
                        res = all.lower(new Info(0, L, 0));
                    }

                    sb.append(res == null ? -1 : res.num).append('\n');
                    break;
                }
            }
        }

        System.out.print(sb.toString());
    }

    // 문제 추가 공통 처리
    static void addInfo(Info info) {
        all.add(info);
        byNum.put(info.num, info);
        byGroup.computeIfAbsent(info.group, k -> new TreeSet<>(COMP))
               .add(info);
    }
}
