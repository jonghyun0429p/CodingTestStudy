import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");

            for (String word : words) {
                StringBuilder temp = new StringBuilder(word);
                sb.append(temp.reverse()).append(" ");
            }
            sb.setLength(sb.length() - 1); // 마지막 공백 제거
            sb.append("\n");
        }

        System.out.print(sb);
    }
}