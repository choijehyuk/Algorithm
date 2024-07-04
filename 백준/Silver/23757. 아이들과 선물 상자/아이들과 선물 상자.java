import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        
        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int gift = pq.poll();
            gift -= Integer.parseInt(st.nextToken());
            if (gift < 0) {
                flag = false;
                break;
            } else if (gift > 0) pq.add(gift);
        }

        System.out.println(flag ? 1 : 0);


    }
}