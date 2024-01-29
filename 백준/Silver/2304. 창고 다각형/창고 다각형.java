import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            list.add(new Point(L, H));
        }

        Collections.sort(list, (o1, o2) -> o1.r - o2.r);

        int sum = 0;
        int max = 0;

        Point before = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Point p = list.get(i);

            if (before.c <= p.c) {
                sum += (p.r - before.r) * before.c;
                before = p;
                max = i;
            }
        }

        before = list.get(list.size() - 1);
        for (int i = 1; i < list.size() - max; i++) {
            Point p = list.get(list.size() - 1 - i);

            if (before.c <= p.c) {
                sum += (before.r - p.r) * before.c;
                before = p;
            }
        }

        sum += list.get(max).c;

        System.out.println(sum);
    }
}