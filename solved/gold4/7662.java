import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCases; i++) {
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            int t = Integer.parseInt(br.readLine());
            for(int j = 0; j < t; j++) {
                String[] operation = br.readLine().split(" ");
                String op = operation[0];
                int a = Integer.parseInt(operation[1]);

                if(op.equals("I")) {
                    tm.put(a, tm.getOrDefault(a, 0) + 1);
                }else{
                    if(!tm.isEmpty()){
                        if(a == -1){
                            int min = tm.firstKey();
                            if(tm.get(min) == 1){
                                tm.remove(min);
                            }else{
                                tm.put(min, tm.get(min) - 1);
                            }
                        } else{
                            int max = tm.lastKey();
                            if(tm.get(max) == 1){
                                tm.remove(max);
                            }else{
                                tm.put(max, tm.get(max) - 1);
                            }
                        }
                    }
                }
            }
            if(tm.isEmpty()){
                System.out.println("EMPTY");
            }else {
                System.out.printf("%d %d\n", tm.lastKey(), tm.firstKey());
            }
        }
    }
}
