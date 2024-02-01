import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int r, c, cnt, move;

        public Point(int r, int c, int cnt, int move) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.move = move;
        }
    }

    static int N, M, K;
    static int[][] map;
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
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                int num = s.charAt(j) - '0';
                map[i][j] = num;
            }
        }

        //print();
        bfs();
        System.out.println("-1");
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, 0));
        v[0][0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            //System.out.println(p.r + " " + p.c + " " + p.cnt + " " + p.move);

            if (p.cnt > K) continue;

            if (p.r == N - 1 && p.c == M - 1) {
                System.out.println(p.move + 1);
                System.exit(0);
            }

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (!isRange(nr, nc)) continue;

                if (map[nr][nc] == 0 && !v[nr][nc][p.cnt]) {
                    q.add(new Point(nr, nc, p.cnt, p.move + 1));
                    v[nr][nc][p.cnt] = true;
                }
                if (p.cnt < K && map[nr][nc] == 1 && !v[nr][nc][p.cnt + 1]) {
                    q.add(new Point(nr, nc, p.cnt + 1, p.move + 1));
                    v[nr][nc][p.cnt + 1] = true;
                }
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
        return false;
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}