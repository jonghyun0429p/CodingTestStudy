import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, N;
	static String[] deck;
	static ArrayList<String> answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            deck = new String[N];
            answer = new ArrayList<>();;
            
            st = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < N; i++) {
            	deck[i] = st.nextToken();
            }
            if(deck.length%2 == 0) {
            	for(int i = 0; i < N/2; i++) {
                	answer.add(deck[i]);
                	answer.add(deck[N/2+i]);
                }
            }else {
            	for(int i = 0; i < N/2; i++) {
                	answer.add(deck[i]);
                	answer.add(deck[N/2+1+i]);
                }
            	answer.add(deck[N/2]);
            }
            
            System.out.print("#"+t+" ");
            for(String s : answer) {
            	System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}
