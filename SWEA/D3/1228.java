import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int testCaseCount = 10;

        for(int test_case = 1; test_case <= 10; test_case++) {

        	List<Integer> result = new LinkedList<Integer>();

        	int codeNum = Integer.parseInt(br.readLine());

        	int[] codes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        	for(int i : codes) {
        		result.add(i);
        	}

        	int commendCount = Integer.parseInt(br.readLine());
        	String[] commends = br.readLine().split("I");

        	for(int i = 1; i <= commendCount; i++) {
        		int[] commend = Arrays.stream(commends[i].trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        		int index = commend[0];
        		int codeCount = commend[1];
        		for(int j = 0; j < codeCount; j++) {
        			result.add(index + j, commend[j + 2]);
        		}
        	}

        	System.out.printf("#%d ", test_case);

        	for(int i = 0 ;i < 10; i++) {
        		System.out.print(result.get(i)+" ");
        	}

        	System.out.println();
        }
    }
}
