import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<Integer> slice_num(String num){
        if(num.contains(".")){
            String[] slice_num = num.split("\\.");
            int left = Integer.parseInt(slice_num[0]);
            int right = Integer.parseInt(slice_num[1]);

            return new ArrayList<Integer>(Arrays.asList(left, right));
        }else{
            int left = Integer.parseInt(num);

            return new ArrayList<Integer>(Arrays.asList(left));
        }
    }

    public static ArrayList<ArrayList<Integer>> sort_list(ArrayList<ArrayList<Integer>> list){
        list.sort((a, b) -> {
            int a0 = a.get(0);
            int b0 = b.get(0);

            int a1 = a.size() > 1 ? a.get(1) + 1 : 0;  // 소수부 있으면 +1, 없으면 0
            int b1 = b.size() > 1 ? b.get(1) + 1 : 0;

            if (a0 != b0) {
                return Integer.compare(a0, b0);  // 첫 번째 기준 정렬
            }
            return Integer.compare(a1, b1);      // 두 번째 기준 정렬
        });

        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> num_list = new ArrayList<>();

        for(int i = 0; i < count; i++){
            String float_num = br.readLine();

            num_list.add(slice_num(float_num));
        }

        num_list = sort_list(num_list);

        for(ArrayList<Integer> list : num_list){
            if(list.size() > 1){
                System.out.printf("%d.%d\n", list.get(0), list.get(1));
            }else{
                System.out.printf("%d\n", list.get(0));
            }
        }
    }
}