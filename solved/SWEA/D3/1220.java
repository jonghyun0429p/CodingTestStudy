import java.util.*;
import java.io.*;

public class Main {

	static int[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = 10;

        for(int test_case = 1; test_case <= 10; test_case++) {

        	int size = Integer.parseInt(br.readLine());

        	table = new int[size][size];
        	int count = 0;

        	for(int i = 0; i < size; i++) {
        		table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	}

        	for(int i = 0; i < size; i++) {
            	boolean isNorth = false;
        		for(int j = 0; j < size; j++) {
        			if(table[j][i] == 1) {
        				isNorth = true;
        			}else if(table[j][i] == 2 && isNorth) {
        				count += 1;
        				isNorth = false;
        			}
        		}
        	}
        	System.out.printf("#%d %d\n", test_case, count);
        }
    }
}