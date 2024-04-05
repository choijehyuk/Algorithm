import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (Math.abs(o1) > Math.abs(o2)) return (int) (Math.abs(o1) - Math.abs(o2));
                else if (Math.abs(o1) == Math.abs(o2)) return (int) (o1 - o2);
                else return -1;
            }
        });

        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(br.readLine());

            if (x == 0) {
                if (pq.isEmpty()) sb.append("0").append("\n");
                else sb.append(pq.poll()).append("\n");
                continue;
            }
            pq.add(x);
        }
        System.out.println(sb);
    }
}