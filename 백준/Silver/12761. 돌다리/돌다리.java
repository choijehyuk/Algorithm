import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int r, cnt;

        public Point(int r, int cnt) {
            this.r = r;
            this.cnt = cnt;
        }
    }

    static int A, B;
    static int N, M;
    static int[] map;
    static boolean[] v;
    static int[] dr;
    static int[] dc;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        map = new int[100001];
        v = new boolean[100001];

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dr = new int[]{-1, 1, A, B, -A, -B};
        dc = new int[]{A, B};

        bfs(N, 0);


    }

    private static void bfs(int r, int cnt) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, cnt));
        v[r] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.r == M) {
                answer = p.cnt;
                System.out.println(answer);
                System.exit(0);
            }
            for (int d = 0; d < 6; d++) {
                int nr = p.r + dr[d];

                if (nr >= 0 && nr < 100001 && !v[nr]) {
                    q.add(new Point(nr, p.cnt + 1));
                    v[nr] = true;
                }
            }

            for (int d = 0; d < 2; d++) {
                int nr = p.r * dc[d];

                if (nr >= 0 && nr < 100001 && !v[nr]) {
                    q.add(new Point(nr, p.cnt + 1));
                    v[nr] = true;
                }
            }

        }
    }


}