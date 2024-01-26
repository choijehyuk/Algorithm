import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    static class Point {
        int num, cnt, target;

        public Point(int num, int cnt, int target) {
            this.num = num;
            this.cnt = cnt;
            this.target = target;
        }
    }

    static int S, T;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int C = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < C; tc++) {
            st = new StringTokenizer(br.readLine());

            S = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            v = new boolean[20000];

            bfs();
        }
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(S, 0, T));
        v[S] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.num == p.target) {
                System.out.println(p.cnt);
                return;
            }

            int kick = p.num * 2;
            if (kick <= p.target + 3 && !v[kick]) {
                q.add(new Point(kick, p.cnt + 1, p.target + 3));
                //v[kick] = true;
            }

            kick = p.num + 1;
            if (kick <= p.target && !v[kick]) {
                q.add(new Point(kick, p.cnt + 1, p.target));
                //v[kick] = true;
            }
        }
    }
}