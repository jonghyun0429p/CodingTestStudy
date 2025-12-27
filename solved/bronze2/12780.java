import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        boolean same;
        int cnt = 0;
        String line = br.readLine();
        String keyword = br.readLine();

        for(int i = 0 ; i <= line.length() - keyword.length(); i++){
            same = false;
            if(line.charAt(i) == keyword.charAt(0)){
                same = true;
                for(int j = 1; j < keyword.length(); j++){
                    if (line.charAt(i+j) != keyword.charAt(j)){
                        same=false;
                        break;
                    }
                }
            }
            if(same){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
