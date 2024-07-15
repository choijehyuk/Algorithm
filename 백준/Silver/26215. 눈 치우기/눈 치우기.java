import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            int a = pq.poll();

            if (pq.isEmpty()) {
                answer += a;
                break;
            }
            int b = pq.poll();
            answer += b;
            pq.add(a - b);
        }

        if (answer > 1440)
            System.out.println(-1);
        else
            System.out.println(answer);
    }
}