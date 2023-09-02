import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int end;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        v = new boolean[N][N];
        answer = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = -1;
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            map[a][b] = i;
        }

        bfs(x, y, 0);

        for (int i = 0; i < M; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static void bfs(int r, int c, int cnt) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, cnt));
        v[r][c] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (map[p.r][p.c] != -1) {
                answer[map[p.r][p.c]] = p.cnt;
                end++;
            }

            if (end == M) {
                return;
            }

            for (int d = 0; d < 8; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
                    q.add(new Point(nr, nc, p.cnt + 1));
                    v[nr][nc] = true;
                }
            }
        }
    }
}