import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] list;
        long sum = 0;

        for(int i = 0; i < 3; i++){
            String color = br.readLine();
            if(i < 2){
                switch (color){
                    case "black":
                        sum += 0;
                        break;
                    case "brown":
                        sum += 1;
                        break;
                    case "red":
                        sum += 2;
                        break;
                    case "orange":
                        sum += 3;
                        break;
                    case "yellow":
                        sum += 4;
                        break;
                    case "green":
                        sum += 5;
                        break;
                    case "blue":
                        sum += 6;
                        break;
                    case "violet":
                        sum += 7;
                        break;
                    case "grey":
                        sum += 8;
                        break;
                    case "white":
                        sum += 9;
                        break;
                }
                if(i == 0) sum *= 10;
            }else{
                switch (color){
                    case "black":
                        sum *= 1;
                        break;
                    case "brown":
                        sum *= 10;
                        break;
                    case "red":
                        sum *= 100;
                        break;
                    case "orange":
                        sum *= 1000;
                        break;
                    case "yellow":
                        sum *= 10000;
                        break;
                    case "green":
                        sum *= 100000;
                        break;
                    case "blue":
                        sum *= 1000000;
                        break;
                    case "violet":
                        sum *= 10000000;
                        break;
                    case "grey":
                        sum *= 100000000;
                        break;
                    case "white":
                        sum *= 1000000000;
                        break;
                }
            }
        }
        System.out.println(sum);
    }
}
