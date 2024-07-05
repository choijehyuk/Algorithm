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

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                pq.offer(new int[]{Integer.parseInt(st.nextToken()), i});
            }

        }

        PriorityQueue<Integer> sushi = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            sushi.offer(Integer.parseInt(st.nextToken()));
        }

        int answer[] = new int[N];

        while (!sushi.isEmpty()) {
            if (pq.isEmpty()) break;

            if (pq.peek()[0] == sushi.peek()) {
                int tmp[] = pq.poll();
                sushi.poll();
                answer[tmp[1]]++;
            } else if (pq.peek()[0] > sushi.peek()) sushi.poll();
            else pq.poll();

        }

        for (int i = 0; i < N; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}