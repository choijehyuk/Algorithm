import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String boom = br.readLine();


        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() >= boom.length()) {
                boolean isSame = true;
                for (int j = 0; j < boom.length(); j++) {
                    if (stack.get(stack.size() - boom.length() + j) != boom.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    for (int j = 0; j < boom.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        for (Character c : stack) {
            sb.append(c);
        }
        if (stack.size() == 0) sb.append("FRULA");
        System.out.println(sb);
    }
}