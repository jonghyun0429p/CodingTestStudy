import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int one, two;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        parents = new int[N];
        
        for(int i = 0; i < N; i++) {
        	parents[i] = i;
        }
        
        for(int i = 1; i <= M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	one = Integer.parseInt(st.nextToken());
        	two = Integer.parseInt(st.nextToken());
        	
        	if(find(one) == find(two)) {
        		System.out.println(i);
        		return;
        	}else {
        		union(one, two);
        	}
        }
        System.out.println(0);
        

    }
    public static int find(int x) {
    	if(parents[x] == x) return x;
    	return parents[x] = find(parents[x]);
    }
    
    public static void union(int x, int y) {
    	int a = find(x);
    	int b = find(y);
    	if(a != b) {
    		if(a > b) parents[a] = b;
        	else parents[b] = a;
    	}
    	
    }
}
