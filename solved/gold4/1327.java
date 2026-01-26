import java.io.*;
import java.util.*;

public class Main {

	//1327
	
	static class State{
		String value;
		int count;
		
		public State(String value, int count) {
			this.value = value;
			this.count = count;
		}
	}
	
	public static String swap(int start, String str) {
		sb = new StringBuilder();
		
		for(int i = 0; i < start; i++) {
			sb.append(str.charAt(i));
		}
		for(int i = start+K-1; i >= start; i--) {
			sb.append(str.charAt(i));
		}
		for(int i = start+K; i < N; i++) {
			sb.append(str.charAt(i));
		}
		
		return sb.toString();
	}
	
	static int K, N;
	static String goal;
	static TreeSet<State> ts;
	static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] lines = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        ts = new TreeSet<State>((a, b) -> {
        	if(a.count != b.count) {
        		return a.count - b.count;
        	}
        	return a.value.compareTo(b.value);
        });
        
        N = lines[0];
        K = lines[1];
        
        String nums = br.readLine().replace(" ", "");
        char[] arr = nums.toCharArray();
        sb = new StringBuilder();        
        
        String number = new String(arr);
        Arrays.sort(arr);
        goal = new String(arr);        

        Map<String, Integer> dist = new HashMap<>();
        dist.put(number, 0);
        
        State state = new State(number, 0);
        ts.add(state);
        
        while(!ts.isEmpty()) {
        	state = ts.pollFirst();
        	
        	if(state.value.equals(goal)) {
        		System.out.println(state.count);
        		return;
        	}
        	
            for (int i = 0; i <= N - K; i++) {
                String next = swap(i, state.value);
                int nextCount = state.count + 1;

                if (!dist.containsKey(next) || dist.get(next) > nextCount) {
                    dist.put(next, nextCount);
                    ts.add(new State(next, nextCount));
                }
            }
        }
        System.out.println(-1);
        
    }
}
