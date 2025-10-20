import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;

            while (input.length() > 1) {
                int sum = 0;
                for (int i = 0; i < input.length(); i++) {
                    sum += input.charAt(i) - '0';
                }
                input = String.valueOf(sum);
            }

            System.out.println(input);
        }
    }
}
