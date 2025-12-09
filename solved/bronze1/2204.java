import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            List<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(br.readLine());
            }

            list.sort((a, b) -> a.toLowerCase().compareTo(b.toLowerCase()));

            System.out.println(list.get(0));
        }
    }
}
