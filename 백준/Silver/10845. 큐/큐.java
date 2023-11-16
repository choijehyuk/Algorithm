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
        Queue<Integer> q = new LinkedList<>();

        int back = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                back = num;
                q.add(num);
            } else if (s.equals("pop")) {
                if (q.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(q.poll() + "\n");
                }
            } else if (s.equals("size")) {
                sb.append(q.size() + "\n");
            } else if (s.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (s.equals("front")) {
                if (q.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(q.peek() + "\n");
                }
            } else if (s.equals("back")) {
                if (q.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(back + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}