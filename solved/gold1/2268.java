import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static long[] data;
	
	static class SegmentTree{
		long[] tree;
		int n;
		
		public SegmentTree(int N) {
			this.n = N;
			this.tree = new long[N*4];
		}
		
		public long init(long[] arr, int node, int start, int end) {			
			if(start == end) {
				return this.tree[node] = arr[start];
			}
			
			return this.tree[node] = init(arr, node*2, start, (start+end)/2) + init(arr, node*2+1, (start+end)/2+1, end);
		}
		
		public long getSum(int node, int start, int end, int left, int right) {
			if(right < start || end < left) {
				return 0;
			}
			
			if(left <= start && end <= right) {
				return this.tree[node];
			}
			
			return getSum(node*2, start, (start+end)/2, left, right) + getSum(node*2+1, (start+end)/2+1, end, left, right);
		}
		
		public void update(int node, int start, int end, int idx, long diff) {
			if(idx < start || end < idx) return;
			
			tree[node] += diff;
			
			if(start != end) {
				update(node*2, start, (start+end)/2, idx, diff);
				update(node*2+1, (start+end)/2+1, end, idx, diff);
			}
		}
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        

        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        N = line[0];
        M = line[1];
        
        data = new long[N+1];
        SegmentTree sTree = new SegmentTree(N);
        
        for(int i = 0; i <= N; i++) {
        	data[i] = 0;
        }
        
        sTree.init(data, 1, 1, N);
        
        for(int i = 0; i < M; i++) {
        	line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	
        	if(line[0] == 0) {
        		if(line[1] < line[2]) {
        			sb.append(sTree.getSum(1, 1, N, line[1], line[2])).append("\n");
        		}else {
        			sb.append(sTree.getSum(1, 1, N, line[2], line[1])).append("\n");
        		}
        		
        	}else {
        		sTree.update(1, 1, N, line[1], line[2] - data[line[1]]);
        		data[line[1]] = line[2];
        	}
        }
        
        System.out.println(sb);
    }
}
