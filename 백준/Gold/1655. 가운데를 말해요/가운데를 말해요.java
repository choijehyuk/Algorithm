import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (minQ.size() == maxQ.size()) maxQ.add(num);
            else minQ.add(num);

            if (!minQ.isEmpty() && !maxQ.isEmpty()) {
                if (minQ.peek() < maxQ.peek()) {
                    int temp = minQ.poll();
                    minQ.add(maxQ.poll());
                    maxQ.add(temp);
                }
            }
            sb.append(maxQ.peek() + "\n");

        }
        System.out.println(sb);
    }
}