import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    static class Point {
        int move, idx;

        public Point(int move, int idx) {
            this.move = move;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        Deque<Point> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.add(new Point(Integer.parseInt(st.nextToken()), i));
        }

        while (true) {
            Point p = deque.poll();
            int num = p.move;
            System.out.print(p.idx + " ");

            if (deque.isEmpty()) {
                break;
            }

            if (num > 0) {
                for (int i = 0; i < num - 1; i++) {
                    Point moveBack = deque.pollFirst();
                    deque.addLast(moveBack);
                }
            } else {
                for (int i = 0; i < Math.abs(num); i++) {
                    Point moveFront = deque.pollLast();
                    deque.addFirst(moveFront);
                }
            }
        }


    }
}