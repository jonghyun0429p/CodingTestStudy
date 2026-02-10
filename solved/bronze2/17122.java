import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            String pos = input[0];
            int num = Integer.parseInt(input[1]);

            int col1 = pos.charAt(0) - 'A';
            int row1 = pos.charAt(1) - '1';
            int color1 = (row1 + col1) % 2;

            int row2 = (num - 1) / 8;
            int col2 = (num - 1) % 8;
            int color2 = (row2 + col2) % 2;

            System.out.println(color1 == color2 ? "YES" : "NO");
        }
    }
}
