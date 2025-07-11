import java.util.*;
import java.io.*;

public class Main {

	static String[] board;
	static String[] codes = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= testCaseCount; testCase++) {
        	int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        	int N = NM[0];
        	int M = NM[1];

        	board = new String[N];

        	for(int i = 0; i < N; i++) {
        		board[i] = br.readLine();
        	}

        	int[] startEnd = findcode();
        	int sum = 0;
        	int num = 0;
        	int checkSum = 0;

        	for(int i = 0; i < 8; i++) {
        		String curNum = board[startEnd[0]].substring(startEnd[1] + (i * 7), startEnd[1] + 7 + (i * 7));
        		for(int j = 0; j < 10; j++) {
        			if (curNum.equals(codes[j])) {
        				num = j;
        			}
        		}
        		if(i % 2 == 0) {
        			checkSum += num*3;
        		}else {
        			checkSum += num;
        		}
        		sum += num;
        	}
        	if(checkSum % 10 == 0) {
        		System.out.printf("#%d %d\n", testCase, sum);
        	}else {
        		System.out.printf("#%d %d\n", testCase, 0);
        	}
        }
    }

    public static int[] findcode() {
    	int[] startEnd;

    	for(int i = 0; i < board.length; i++) {
    		for(int j = board[0].length()-1; j >= 0; j--) {
    			if(board[i].charAt(j) == '1') {
    				startEnd = new int[] {i, j-55, i, j+1};
    				return startEnd;
    			}
    		}
    	}
    	return new int[] {0};
    }
}
