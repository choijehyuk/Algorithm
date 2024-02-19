import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int r, c, cnt, bust;

        public Point(int r, int c, int cnt, int bust) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.bust = bust;
        }
    }

    static int N, M;
    static int[][] map;
    static int startX, startY;
    static int endX, endY;
    static boolean[][][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M][2];

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken()) - 1;
        endY = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(startX, startY);
        System.out.println("-1");

    }

    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, 0, 0));
        v[r][c][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.r == endX && p.c == endY) {
                System.out.println(p.cnt);
                System.exit(0);
            }

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (!isRange(nr, nc)) continue;
                if (map[nr][nc] == 0 && !v[nr][nc][1] && p.bust == 1) {
                    q.add(new Point(nr, nc, p.cnt + 1, p.bust));
                    v[nr][nc][1] = true;
                }
                if (map[nr][nc] == 0 && !v[nr][nc][0] && p.bust == 0) {
                    q.add(new Point(nr, nc, p.cnt + 1, p.bust));
                    v[nr][nc][0] = true;
                }
                if (map[nr][nc] == 1 && !v[nr][nc][1] && p.bust == 0) {
                    q.add(new Point(nr, nc, p.cnt + 1, p.bust + 1));
                    v[nr][nc][1] = true;
                }

            }
        }

    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
        return false;
    }
}