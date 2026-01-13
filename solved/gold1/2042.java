import java.io.*;
import java.util.*;

public class Main {

	static int M, N, K;
	
	static class SegmentTree{
		long[] tree;
		int n;
		
		public SegmentTree(int n) {
			this.n = n;
			tree = new long[4*n];
		}
		
		public long init(int[] arr, int node, int start, int end) {
			if(start == end) {
				return tree[node] = arr[start];
			}			
			return tree[node] = init(arr, node*2, start, (start+end)/2) + init(arr, node*2+1, (start+end)/2+1, end);
		}
		
		public long getSum(int node, int start, int end, int left, int right) {
			if(end < left || right < start) {
				return 0;
			}else if(left <= start && right >= end) {
				return tree[node];
			}
			return getSum(node*2, start, (start+end)/2, left, right) + getSum(node*2+1, (start+end)/2+1, end, left, right);
		}
		
		public void update(int node, int start, int end, int idx, long diff) {
			if(idx < start || end < idx) {
				return;
			}
			tree[node] += diff;
			if (start == end) return;
			update(node*2, start, (start+end)/2, idx, diff);
			update(node*2+1, (start+end)/2+1, end, idx, diff);
		}
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        N = line[0];
        M = line[1];
        K = line[2];
        
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
        	int a = Integer.parseInt(br.readLine());
        	arr[i] = a;
        }
        
        SegmentTree sTree = new SegmentTree(N);
        sTree.init(arr, 1, 0, N-1);
        
        for(int i = 0; i < M+K; i++) {
        	line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	
            if (line[0] == 1) {
                int idx = line[1] - 1;
                long newValue = line[2];
                long diff = newValue - arr[idx];
                arr[idx] = (int)newValue;
                sTree.update(1, 0, N - 1, idx, diff);

            } else {
                int left = line[1] - 1;
                int right = line[2] - 1;
                sb.append(sTree.getSum(1, 0, N - 1, left, right)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
