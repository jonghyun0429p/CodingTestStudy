import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());

        for(int test = 0; test < cnt; test++){
            int a = Integer.parseInt(br.readLine());

            for(int i = 0; i < a; i++){
                for(int j = 0; j < a; j++){
                    if(i == 0 || j == 0 || i == a-1 || j == a-1){
                        sb.append("#");
                    }else{
                        sb.append("J");
                    }

                    if(j == a-1){
                        sb.append("\n");
                    }

                    if(i == a-1 && j == a-1 && test != cnt-1){
                        sb.append("\n");
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}