import java.io.*;
import java.util.*;

public class Solution {

	static int T, K, num, dir;
	static LinkedList<Integer>[] lists;
	static LinkedList<int[]> q;
	static boolean[] visited;
	static boolean[] rel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {        	
        	K = Integer.parseInt(br.readLine());
        	q = new LinkedList<>();
        	lists = new LinkedList[4];
        	
        	for(int i = 0; i < 4; i++) {
        		lists[i] = new LinkedList<>();
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < 8; j++) {
        			lists[i].add(Integer.parseInt(st.nextToken()));
        		}
        	}
        	
        	for(int i = 0; i < K; i++) {
        		st = new StringTokenizer(br.readLine());
        		
        		
        		rel = new boolean[3];
        		visited = new boolean[4];
        		num = Integer.parseInt(st.nextToken());
        		dir = Integer.parseInt(st.nextToken());
        		
        		int idx = num-1;
        		
        		getRel();
        		q.add(new int[] {idx, dir});
        		visited[idx] = true;
        		
        		while(!q.isEmpty()) {
        			int[] cur = q.poll();
        			lotation(cur[0], cur[1]);
        			
        			if (cur[0] < 3 && !visited[cur[0]+1] && rel[cur[0]]) {
        			    q.add(new int[]{cur[0]+1, cur[1]*-1});
        			    visited[cur[0]+1] = true;
        			}
        			if (cur[0] > 0 && !visited[cur[0]-1] && rel[cur[0]-1]) {
        			    q.add(new int[]{cur[0]-1, cur[1]*-1});
        			    visited[cur[0]-1] = true;
        			}     	
        		}
        	}
    		System.out.println("#"+tc+" "+getValue());
        }
    }
    static void getRel() {
    	for(int i = 0; i < 3; i++) {
    		if(lists[i].get(2) != lists[i+1].get(6)) {
    			rel[i] = true;
    		}
    	}
    }
    
    static void lotation(int idx, int dir) {
		if(dir == 1) {
			int temp = lists[idx].pollLast();
			lists[idx].addFirst(temp);
		}else if(dir == -1){
			int temp = lists[idx].poll();
			lists[idx].addLast(temp);
		}
    }
    
    static int getValue() {
    	int result = 0;
    	for(int i = 0; i < 4; i++) {
    		if(lists[i].get(0) == 1) {
    			result += (1<<i);
    		}
    	}
    	return result;
    }
}
