import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static long[] data, minTree, maxTree;
	
	static long makeMin(int node, int start, int end) {
		if(start == end) {
			return minTree[node] = data[start];
		}
		
		return minTree[node] = Math.min(makeMin(node*2, start, (start+end)/2), makeMin(node*2+1, (start+end)/2+1, end));
	}
	
	static long makeMax(int node, int start, int end) {
		if(start == end) {
			return maxTree[node] = data[start];
		}
		
		return maxTree[node] = Math.max(makeMax(node*2, start, (start+end)/2), makeMax(node*2+1, (start+end)/2+1, end));
	}
	
	static long findMin(int node, int start, int end, int left, int right) {
		if(right < start || left > end) {
			return Long.MAX_VALUE;
		}
		
		if(left <= start && right >= end) {
			return minTree[node];
		}
		
		return Math.min(findMin(node*2, start, (start+end)/2, left, right), findMin(node*2+1, (start+end)/2+1, end, left, right));
	}
	
	
	
	static long findMax(int node, int start, int end, int left, int right) {
		if(right < start || left > end) {
			return Long.MIN_VALUE;
		}
		
		if(left <= start && right >= end) {
			return maxTree[node];
		}
		
		return Math.max(findMax(node*2, start, (start+end)/2, left, right), findMax(node*2+1, (start+end)/2+1, end, left, right));
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        N = line[0];
        M = line[1];
        
        data = new long[N+1];
        minTree = new long[N*4];
        maxTree = new long[N*4];
        
        for(int i = 1; i <= N; i++) {
        	data[i] = Long.parseLong(br.readLine());
        }
        
        makeMin(1, 1, N);
        makeMax(1, 1, N);
        
        for(int i = 0; i < M; i++) {
        	line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	
        	sb.append(findMin(1, 1, N, line[0], line[1])).append(" ").append(findMax(1, 1, N, line[0], line[1])).append("\n");
        }
        
        System.out.println(sb);
    }
}
