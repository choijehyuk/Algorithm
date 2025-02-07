import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int seq = 1;
        while (true) {
            String s = br.readLine();

            boolean end = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '-') {
                    end = true;
                    break;
                }
            }

            if (end) {
                break;
            }

            int size = s.length();
            int cnt = 0;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < size; i++) {
                char c = s.charAt(i);

                if (c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        cnt++;
                        stack.push('{');
                    } else {
                        stack.pop();
                    }
                }
            }

            sb.append((seq++) + ". " + (cnt + stack.size() / 2) + "\n");
        }

        System.out.println(sb);

    }
}