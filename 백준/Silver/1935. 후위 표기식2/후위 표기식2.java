import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Deque<Double> deque = new ArrayDeque<>();
        double[] arr = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            double answer = 0;
            if (c - 'A' >= 0 && c - 'A' <= 26) {
                deque.push(arr[c - 'A']);
            } else {
                double first = deque.pop();
                double second = deque.pop();

                if (c == '+') {
                    answer = second + first;
                    deque.push(answer);
                } else if (c == '-') {
                    answer = second - first;
                    deque.push(answer);
                } else if (c == '*') {
                    answer = second * first;
                    deque.push(answer);
                } else if (c == '/') {
                    answer = second / first;
                    deque.push(answer);
                }
            }
        }
        System.out.println(String.format("%.2f", deque.pollLast()));
    }
}