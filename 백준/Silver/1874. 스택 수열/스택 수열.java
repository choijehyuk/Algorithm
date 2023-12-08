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
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        int num = 1;
        stack.push(num);
        sb.append("+\n");

        while (idx < N) {
            if (!stack.isEmpty() && arr[idx] < stack.peek()) {
                System.out.println("NO");
                System.exit(0);
            }

            if (!stack.isEmpty() && arr[idx] == stack.peek()) {
                sb.append("-\n");
                stack.pop();
                idx++;

            } else if (stack.isEmpty() || arr[idx] > stack.peek()) {
                num++;
                sb.append("+\n");
                stack.push(num);

            }

        }

        System.out.println(sb);
    }

}