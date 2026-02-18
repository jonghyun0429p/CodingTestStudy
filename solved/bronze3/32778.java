import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (input.contains("(")) {
            int openIndex = input.indexOf('(');
            int closeIndex = input.indexOf(')');

            String stationName = input.substring(0, openIndex - 1);
            String subStationName = input.substring(openIndex + 1, closeIndex);

            System.out.println(stationName);
            System.out.println(subStationName);
        } else {
            System.out.println(input);
            System.out.println("-");
        }
    }
}