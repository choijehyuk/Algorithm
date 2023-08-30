import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();


        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            int len = s.length();
            stack.push(s.charAt(0));

            for (int j = 1; j < len; j++) {
                char c = s.charAt(j);
                if (!stack.isEmpty()) {
                    char cc = stack.peek();
                    if (c == cc) {
                        stack.pop();
                        continue;
                    }
                }
                stack.push(c);
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }
        System.out.println(answer);
    }

}