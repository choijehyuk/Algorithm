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

    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int answer;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!v[i][j] && map[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);

    }

    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        v[r][c] = true;
        int num = map[r][c];
        flag = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (!nearCheck(p.r , p.c)) {
                flag = false;
            }

            for (int d = 0; d < 8; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == num && !v[nr][nc]) {

                    q.add(new Point(nr, nc));
                    v[nr][nc] = true;
                }
            }
        }
        if (flag) {
            answer++;
        }
    }

    private static boolean nearCheck(int nr, int nc) {
        for (int d = 0; d < 8; d++) {
            int nnr = nr + dr[d];
            int nnc = nc + dc[d];

            if (nnr >= 0 && nnr < N && nnc >= 0 && nnc < M) {
                if (map[nnr][nnc] > map[nr][nc]) {
                    return false;
                }
            }
        }
        return true;
    }
}
