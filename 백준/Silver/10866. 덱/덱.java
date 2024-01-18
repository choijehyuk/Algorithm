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

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int num = 0;
            if (command.equals("push_front") || command.equals("push_back")) {
                num = Integer.parseInt(st.nextToken());
            }

            if (command.equals("push_front")) {
                deque.addFirst(num);
            } else if (command.equals("push_back")) {
                deque.addLast(num);
            } else if (command.equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(deque.pollFirst() + "\n");
            } else if (command.equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(deque.pollLast() + "\n");
            } else if (command.equals("size")) {
                sb.append(deque.size() + "\n");
            } else if (command.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (command.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(deque.getFirst() + "\n");
            } else if (command.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(deque.getLast() + "\n");
            }
        }
        System.out.println(sb);
    }
}