import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        for (int i = 0; i < T; i++) {
            if (q.peek() < H || q.peek() == 1) break;
            cnt++;

            q.add(q.poll() / 2);
        }

        if (q.peek() < H) sb.append("YES").append("\n").append(cnt);
        else sb.append("NO").append("\n").append(q.poll());

        System.out.println(sb);


    }
}