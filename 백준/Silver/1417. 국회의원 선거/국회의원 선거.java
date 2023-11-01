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
        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N - 1; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (!q.isEmpty()) {
            int num = q.poll();

            if (q.size() == 0) {
                if (dasom > num) {
                    System.out.println(answer);
                    System.exit(0);
                }
            }

            if (dasom > num && q.size() != 0 && dasom > q.peek()) {
                System.out.println(answer);
                System.exit(0);
            }
            dasom++;
            num--;
            answer++;
            q.add(num);

        }
        System.out.println(0);
    }


}