import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = 10;

        for(int test_case = 1; test_case <= 10; test_case++) {

        	int testNum = Integer.parseInt(br.readLine());

        	String findStr = br.readLine();
        	int findStrLength = findStr.length();
        	String str = br.readLine();
        	int strLength = str.length();



        	int left = 0;
        	int right = findStrLength - 1;
        	int count = 0;

        	while(right < strLength) {
            	boolean isSame = false;
        		if(str.charAt(left) == findStr.charAt(0)) {
        			isSame = true;
        			for(int i = 0; i < findStrLength; i++) {
        				if(str.charAt(left+i) != findStr.charAt(i)) {
        					isSame = false;
        					break;
        				}
        			}
        			if(isSame) {
        				count += 1;
        			}
        		}
        		left += 1;
        		right += 1;
        	}

        	System.out.println(count);
        }
    }
}
