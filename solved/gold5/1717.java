import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	static int find(int a) {
		if(a == parents[a]) return a;
		else return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		int Pa = find(a);
		int Pb = find(b);
		
		if(Pa == Pb) return;
		if (Pa <= Pb) parents[Pb] = Pa;
		else parents[Pa] = Pb;
	}
	
	static boolean isUnion(int a, int b) {
		if(parents[a] == parents[b]) return true;
		else return false;
	}
	static int[] parents;
	static int N, M;
	static int[] line;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        N = line[0]+1;
        M = line[1];
        
        parents = new int[N];
        
        for(int i = 0; i < N; i++) {
        	parents[i] = i;
        }
        
        for(int i = 0; i < M; i++) {
        	line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	
        	if(line[0] == 0) {
        		union(line[1], line[2]);
        	}else {
        		if(isUnion(line[1], line[2])) {
        			sb.append("YES\n");
        		}else {
        			sb.append("NO\n");
        		}
        	}
        }
        
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
