import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static char[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int garoanswer;
    static int seroanswer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j] && map[i][j] == '.') {
                    garo(i, j);
                }
            }
        }

        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j] && map[i][j] == '.') {
                    sero(i, j);
                }
            }
        }

        System.out.println(garoanswer + " " + seroanswer);

    }

    private static void sero(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        v[r][c] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c;

                if (nr >= 0 && nr < N && !v[nr][nc] && map[nr][nc] != 'X') {
                    q.add(new Point(nr, nc));
                    v[nr][nc] = true;
                    cnt++;
                }
            }
        }
        if (cnt >= 1) {
            seroanswer++;
        }

    }

    private static void garo(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        v[r][c] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r;
                int nc = p.c + dc[d];

                if (nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] != 'X') {
                    q.add(new Point(nr, nc));
                    v[nr][nc] = true;
                    cnt++;
                }
            }
        }
        if (cnt >= 1) {
            garoanswer++;
        }
    }
}
