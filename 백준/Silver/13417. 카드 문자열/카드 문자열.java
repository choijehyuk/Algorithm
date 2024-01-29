import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            Deque<String> q = new ArrayDeque<>();

            q.add(st.nextToken());
            for (int i = 1; i < N; i++) {
                String s = st.nextToken();

                String first = q.peekFirst();
                String last = q.peekLast();
                if (s.charAt(0) <= first.charAt(0)) {
                    q.addFirst(s);
                } else {
                    q.addLast(s);
                }
            }

            while (!q.isEmpty()) {
                System.out.print(q.poll());
            }
            System.out.println();
        }
    }
}