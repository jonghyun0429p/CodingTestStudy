import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, K, digit;
	static LinkedList<Character> nums;
	static HashSet<Integer> values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
        	StringBuilder sb = new StringBuilder();
        	
        	N = Integer.parseInt(st.nextToken());
        	digit = N/4;
        	K = Integer.parseInt(st.nextToken());
        	nums = new LinkedList<>();
        	values = new HashSet<>();
        	
        	String line = br.readLine();
        	
        	for(int i = 0; i < N; i++) {
        		nums.add(line.charAt(i));
        	}
        	
        	for(int cycle = 0; cycle < digit; cycle++) {
            	for(int i = 0; i < N; i++) {            		
            		sb.append(nums.get(i));
            		if(sb.length() == digit) {
            			values.add(Integer.parseInt(sb.toString(), 16));
            			sb = new StringBuilder();
            		}
            	}
            	char tempt = nums.pollLast();
            	nums.addFirst(tempt);
        	}
        	
        	int[] numbers = values.stream()
        		    .sorted(Comparator.reverseOrder())
        		    .mapToInt(Integer::intValue)
        		    .toArray();
        	System.out.println("#"+tc+" "+numbers[K-1]);
        }
    }
}
