import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < cnt; i++){
            int result = 0;
            String line = br.readLine();

            for(int j = 0; j < line.length(); j++){
                if(line.charAt(j)!=' ') {
                    result += (int) line.charAt(j) - 64;
                }
            }

            if(result == 100){
                System.out.println("PERFECT LIFE");
            }else{
                System.out.println(result);
            }
        }

    }
}
