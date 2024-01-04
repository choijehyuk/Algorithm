import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    static class Point implements Comparable<Point> {
        int r, c, cnt, dir;

        public Point(int r, int c, int cnt, int dir) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.dir = dir;
        }

        @Override
        public int compareTo(Point o) {
            return this.cnt - o.cnt;
        }
    }

    static int N;
    static char[][] map;
    static int startDoorX, startDoorY;
    static int endDoorX, endDoorY;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        boolean isFirst = true;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == '#') {
                    if (isFirst) {
                        startDoorX = i;
                        startDoorY = j;
                        isFirst = false;
                    } else {
                        endDoorX = i;
                        endDoorY = j;
                    }
                }
            }
        }

        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        PriorityQueue<Point> q = new PriorityQueue<>();
        boolean[][][] v = new boolean[N][N][4];

        for (int i = 0; i < 4; i++) {
            q.add(new Point(startDoorX, startDoorY, 0, i));
        }

        while (!q.isEmpty()) {
            Point p = q.poll();
            v[p.r][p.c][p.dir] = true;

            if (p.r == endDoorX && p.c == endDoorY) {
                answer = Math.min(answer, p.cnt);
            }

            int nr = p.r + dr[p.dir % 4];
            int nc = p.c + dc[p.dir % 4];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc][p.dir] && map[nr][nc] != '*') {
                if (map[nr][nc] == '!') {

                    int nDir = (p.dir + 1) % 4;
                    q.add(new Point(nr, nc, p.cnt + 1, nDir));

                    nDir = (p.dir + 3) % 4;
                    q.add(new Point(nr, nc, p.cnt + 1, nDir));
                }
                q.add(new Point(nr, nc, p.cnt, p.dir));
            }

        }
    }

}