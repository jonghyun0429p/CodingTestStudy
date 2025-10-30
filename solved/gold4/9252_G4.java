import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	//LCS�� �ؾ��ϴµ�, ���̴� ���ϴ� ����� �ƴµ�, ���� ã������ �������� �ؾ���.
	//1000���ڸ� 1000�� 1000���� �ϴ� ���Ϸ��� ������ ��� ���� �����س���.dp���� ���ڰ� ���ϸ� �� �� �ε����� ���� �ִ´�?
	
	static String first, second;
	static int[][] LCS;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        first = br.readLine();
        second = br.readLine();
        
        LCS = new int[second.length()+1][first.length()+1];
        
        for(int i = 1; i <= second.length(); i++) {
        	for(int j = 1; j <= first.length(); j++) {
        		if(second.charAt(i-1) == first.charAt(j-1)) {
        			LCS[i][j] = LCS[i-1][j-1] + 1;
        		}else {
        			LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
        		}
        	}
        }
        
        System.out.println(LCS[second.length()][first.length()]);
        if(LCS[second.length()][first.length()] > 0) {
        	System.out.println(getString());
        }
        
        
        
    }  
    public static String getString() {
    	StringBuilder sb = new StringBuilder();
    	int i = second.length();
    	int j = first.length();
    	
    	while(i > 0 && j > 0) {    		
            if (LCS[i][j]-1 == LCS[i][j-1]) {
                sb.append(first.charAt(j - 1));
                System.out.println(i+" "+j);
                i--; j--;
            } else if (LCS[i - 1][j] >= LCS[i][j - 1]) {
                i--;
            } else {
                j--;
            }
    	}
    	
    	return sb.reverse().toString();
    }
}
