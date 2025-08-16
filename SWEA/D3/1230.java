import java.io.*;
import java.util.*;

public class Solution {

    static int T, N, M;
    static LinkedList<Integer> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = 10;

        for(int tc = 1; tc <= T; tc++) {
            String next;
            list = new LinkedList<>();
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int x, y;
            ArrayList<Integer> s;
            while(st.hasMoreTokens()){
                next = st.nextToken();
                s = new ArrayList<>();
                switch (next){
                    case "I":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());

                        for(int i = 0; i < y; i++){
                            s.add(Integer.parseInt(st.nextToken()));
                        }

                        list.addAll(x, s);
                        break;
                    case "D":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for(int i = 0; i < y; i++){
                            list.remove(x);
                        }
                        break;
                    case "A":
                        y = Integer.parseInt(st.nextToken());
                        for(int i = 0; i < y; i++){
                            list.add(Integer.parseInt(st.nextToken()));
                        }
                        break;
                }
            }
            System.out.print("#" + tc+" ");
            for(int i = 0; i < 10; i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();


        }
    }
}
