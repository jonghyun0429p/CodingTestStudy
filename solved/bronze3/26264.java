import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int secCount = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'y') secCount++; // security 개수
        }

        if (secCount * 2 > count) {
            System.out.println("security!");
        } else if (secCount * 2 < count) {
            System.out.println("bigdata?");
        } else {
            System.out.println("bigdata? security!");
        }
    }
}
