import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        char[] oneHole = {'A', 'a', 'b', 'D', 'd', 'e', 'g', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', '@'};

        String line = br.readLine();
        int count = 0;

        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == 'B'){
                count += 2;
            }else{
                for(char c : oneHole){
                    if(line.charAt(i) == c){
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
