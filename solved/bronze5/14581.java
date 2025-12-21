import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        sb.append(":fan::fan::fan:\n:fan::");

        sb.append(br.readLine());

        sb.append("::fan:\n:fan::fan::fan:");
        System.out.println(sb);

    }
}
