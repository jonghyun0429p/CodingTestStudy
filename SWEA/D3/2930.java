import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {

    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        PriorityQueue<Integer> pq;
        int cnt, cal, num;

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            sb = new StringBuilder();
            cnt = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>(Comparator.reverseOrder());

            for(int i = 0; i < cnt; i++){
                st = new StringTokenizer(br.readLine());

                cal = Integer.parseInt(st.nextToken());

                if(cal == 1){
                    num = Integer.parseInt(st.nextToken());
                    pq.add(num);
                }else{
                    if(!pq.isEmpty()){
                        sb.append(pq.poll()).append(" ");
                    }else{
                        sb.append(-1).append(" ");
                    }
                }
            }
            System.out.println("#"+tc+" "+sb.toString());
        }
    }
}