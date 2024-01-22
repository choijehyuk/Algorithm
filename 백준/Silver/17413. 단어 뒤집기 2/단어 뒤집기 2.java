import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        boolean tag = false;

        for (int i = 0; i < s.length(); i++) {


            if (s.charAt(i) == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                tag = true;
            } else if (s.charAt(i) == '>') {
                sb.append(s.charAt(i));
                tag = false;
                continue;
            }

            if (tag) {
                sb.append(s.charAt(i));
            } else {
                if (s.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                } else {
                    stack.push(s.charAt(i));
                }
            }

            if (i == s.length() - 1) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }

        }

        System.out.println(sb);

    }
}