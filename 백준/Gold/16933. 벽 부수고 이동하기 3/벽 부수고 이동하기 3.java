import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int r, c, cnt, bust, day;

        public Point(int r, int c, int cnt, int bust, int day) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.bust = bust;
            this.day = day;
        }
    }

    static int N, M, K;
    static int[][] map;
    static boolean[][][][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M][K + 1][2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - 48;
            }
        }

        bfs(0, 0);
        System.out.println(answer);
        //print(map);
    }

    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, 1, 0, 0));
        v[r][c][0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.r == N - 1 && p.c == M - 1) {
                System.out.println(p.cnt);
                System.exit(0);
            }

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (!isRange(nr, nc)) continue;

                if (map[nr][nc] == 0) {
                    if (p.day == 0 && !v[nr][nc][p.bust][1]) {
                        q.add(new Point(nr, nc, p.cnt + 1, p.bust, 1));
                        v[nr][nc][p.bust][1] = true;
                    } else if (p.day == 1 && !v[nr][nc][p.bust][0]) {
                        q.add(new Point(nr, nc, p.cnt + 1, p.bust, 0));
                        v[nr][nc][p.bust][0] = true;
                    }
                } else {
                    if (p.bust < K && p.day == 0 && !v[nr][nc][p.bust + 1][1]) {
                        q.add(new Point(nr, nc, p.cnt + 1, p.bust + 1, 1));
                        v[nr][nc][p.bust + 1][1] = true;
                    } else if (p.bust < K && p.day == 1 && !v[p.r][p.c][p.bust][0]) {
                        q.add(new Point(p.r, p.c, p.cnt + 1, p.bust, 0));
                        v[p.r][p.c][p.bust][0] = true;
                    }
                }
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
        return false;
    }

    private static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}