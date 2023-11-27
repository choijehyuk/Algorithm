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
        PriorityQueue<Long> q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());

            if (num == 0) {
                if (q.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(q.poll());
                }
                continue;
            }
            q.add(num);
        }
    }

}