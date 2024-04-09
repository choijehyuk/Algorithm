import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() < s.charAt(i) && cnt < K) {
                stack.pop();
                cnt++;
            }
            stack.push(s.charAt(i));
        }

        while (cnt < K) {
            stack.pop();
            cnt++;
        }

        for (Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb);

    }
}