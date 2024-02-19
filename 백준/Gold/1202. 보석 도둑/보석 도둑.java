import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int weight, price;

        public Point(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Point> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            list.add(new Point(M, V));
        }
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.weight == o2.weight) {
                    return o2.price - o1.price;
                }
                return o1.weight - o2.weight;
            }
        });

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());
            arr[i] = C;
        }
        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        int idx = 0;
        for (int i = 0; i < K; i++) {
            for (int j = idx; j < N; j++) {
                if (list.get(j).weight <= arr[i]) {
                    idx++;
                    pq.add(list.get(j).price);
                } else {
                    break;
                }
            }
            if(pq.isEmpty()) continue;
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}