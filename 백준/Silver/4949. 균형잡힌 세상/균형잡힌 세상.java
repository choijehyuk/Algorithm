import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();

            if (s.equals(".")) break;
            ;

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                } else if (s.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.peek().equals('(')) {
                        stack.pop();
                    } else stack.push(s.charAt(i));
                } else if (s.charAt(i) == '[') {
                    stack.push(s.charAt(i));
                } else if (s.charAt(i) == ']') {
                    if (!stack.isEmpty() && stack.peek().equals('[')) {
                        stack.pop();
                    } else stack.push(s.charAt(i));
                }
            }

            sb.append(stack.isEmpty() ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }
}