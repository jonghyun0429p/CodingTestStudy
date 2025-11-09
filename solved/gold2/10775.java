import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int G, P, cur, answer;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parents = new int[G+1];
        answer = 0;

        for(int i = 1; i <= G; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < P; i++) {
            cur = Integer.parseInt(br.readLine());

            if(find(cur) != 0) {
                answer++;
                union(find(cur)-1, cur);
            }else {
                System.out.println(answer);
                return;
            }
        }
        System.out.println(answer);
    }


    public static int find(int x) {
        if(x == parents[x]) return parents[x];
        else return parents[x] = find(parents[x]);
    }

    public static void union(int a, int b) {
        int ap = find(a);
        int bp = find(b);
//		if(ap < bp)
        parents[bp] = ap;
//		else parents[ap] = bp;
    }
}
