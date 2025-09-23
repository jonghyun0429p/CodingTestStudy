import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine().trim();

        StringBuilder out = new StringBuilder();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (isOperand(ch)) {
                out.append(ch);
            } else if (ch == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (!op.isEmpty() && op.peek() != '(') {
                    out.append(op.pop());
                }
                if (!op.isEmpty() && op.peek() == '(') op.pop();
            } else {
                while (!op.isEmpty() && op.peek() != '('
                        && prec(op.peek()) >= prec(ch)) {
                    out.append(op.pop());
                }
                op.push(ch);
            }
        }

        while (!op.isEmpty()) {
            out.append(op.pop());
        }

        System.out.println(out.toString());
    }

    private static boolean isOperand(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static int prec(char op) {
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0; // '(' 등
    }
}
