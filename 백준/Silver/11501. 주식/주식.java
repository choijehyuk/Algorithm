import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                stack.push(Integer.parseInt(st.nextToken()));
            }

            long max = 0;
            long answer = 0;

            while (!stack.isEmpty()) {
                int num = stack.pop();

                max = Math.max(max, num);

                answer += max - num;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}