import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static char[][] map;
    static boolean[][] v;
    static int startX, startY;
    static int endX, endY;
    static int[][] start;
    static int[][] end;
    static int answer = Integer.MAX_VALUE;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        v = new boolean[N][M];
        start = new int[N][M];
        end = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                if (map[i][j] == 'H') {
                    endX = i;
                    endY = j;
                }
            }
        }

        //print(map);
        bfs(startX, startY, 0);
        homeBfs(endX, endY, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'F') {

                    if (start[i][j] == 0 || end[i][j] == 0) continue;
                    answer = Math.min(answer, start[i][j] + end[i][j]);
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void bfs(int r, int c, int cnt) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, cnt));
        v[r][c] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 'D' && !v[nr][nc]) {
                    q.add(new Point(nr, nc, p.cnt + 1));
                    v[nr][nc] = true;
                    start[nr][nc] = p.cnt + 1;
                }
            }
        }
    }

    private static void homeBfs(int r, int c, int cnt) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, cnt));
        boolean[][] vv = new boolean[N][M];
        vv[r][c] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();


            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !vv[nr][nc] && map[nr][nc] != 'D') {
                    q.add(new Point(nr, nc, p.cnt + 1));
                    vv[nr][nc] = true;
                    end[nr][nc] = p.cnt + 1;
                }
            }
        }
    }

    private static void print(char[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}