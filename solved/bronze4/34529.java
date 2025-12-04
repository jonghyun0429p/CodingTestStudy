import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int X, Y, Z, U, V, W;

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        U = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        System.out.println(U/100*X+V/50*Y+W/20*Z);
    }
}
