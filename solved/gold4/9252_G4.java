import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	//LCS를 해야하는데, 길이는 구하는 방법을 아는데, 값을 찾으려면 역추적을 해야함.
	//1000글자면 1000개 1000개라서 싹다 비교하려면 많은데 어떻게 값을 추출해낼지.dp에서 숫자가 변하면 그 전 인덱스인 것을 넣는다?
	
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
