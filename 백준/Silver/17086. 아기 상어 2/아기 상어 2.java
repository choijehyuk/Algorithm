import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
    static int[][] v;
    static int answer = Integer.MIN_VALUE;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                v[i][j] = Integer.MAX_VALUE;
                if(map[i][j] == 1){
                    q.add(new Point(i,j));
                    v[i][j] = 0;
                }

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);

    }

    private static void bfs(int r, int c) {
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 8; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (v[nr][nc] > v[p.r][p.c] + 1) {
                        v[nr][nc] = v[p.r][p.c] + 1;
                        answer = Math.max(answer, v[nr][nc]);
                        q.add(new Point(nr, nc));
                    }

                }
            }

        }
    }


}