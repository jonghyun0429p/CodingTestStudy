import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (true) {
            List<String> words = new ArrayList<>();

            while (!(line = br.readLine()).equals("#")) {
                words.add(line);
            }

            if (words.isEmpty()) break;

            boolean correct = true;
            int len = words.get(0).length();

            for (String w : words) {
                if (w.length() != len) {
                    correct = false;
                    break;
                }
            }

            if (correct) {
                for (int i = 0; i < words.size() - 1; i++) {
                    if (diffCount(words.get(i), words.get(i + 1)) != 1) {
                        correct = false;
                        break;
                    }
                }
            }

            System.out.println(correct ? "Correct" : "Incorrect");
        }
    }

    private static int diffCount(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt;
    }
}
