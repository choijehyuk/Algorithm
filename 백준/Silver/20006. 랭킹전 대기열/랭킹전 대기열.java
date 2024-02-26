import java.text.CollationElementIterator;
import java.util.*;
import java.io.*;

public class Main {
    static class Point implements Comparable<Point> {
        int level;
        String name;

        public Point(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Point o) {
            return name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Point[] points = new Point[p];
        boolean[] v = new boolean[p];

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            points[i] = new Point(l, n);
        }

        for (int i = 0; i < p; i++) {
            ArrayList<Point> list = new ArrayList<>();
            if (!v[i]) {
                for (int j = i; j < p; j++) {
                    if (list.size() == m) break;

                    int level = points[j].level;
                    String name = points[j].name;
                    if (!v[j] && Math.abs(points[i].level - level) <= 10) {
                        v[j] = true;
                        list.add(new Point(level, name));
                    }
                }
                Collections.sort(list);

                if (list.size() == m) {
                    sb.append("Started!").append("\n");
                } else {
                    sb.append("Waiting!").append("\n");
                }

                for (Point point : list) {
                    sb.append(point.level).append(" ").append(point.name).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}