import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, Cur, Max;
	static int[] Nlist, values, InputList;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        Max = 0;

        Nlist = new int[1000001];
        values = new int[N+1];
        InputList = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= N; i++) {
        	Cur = Integer.parseInt(st.nextToken());
        	
        	Nlist[Cur] = i;
        	InputList[i] = Cur;
        	
        	Max = Math.max(Max, Cur);
        }
        
        
        for(int i = 1; i <= N; i++) {
        	Cur = InputList[i];
        	while(Cur < Max) {
        		Cur += InputList[i];
        		if(Cur <= Max) {
            		if(Nlist[Cur] != 0) {
            			values[i]++;
            			values[Nlist[Cur]]--;
            		}        			
        		}
        	}
        }
        
        for(int i = 1; i <= N; i++) {
        	sb.append(values[i]).append(" ");
        }
        
        sb.deleteCharAt(sb.length()-1);
        
        System.out.println(sb);
    }
}