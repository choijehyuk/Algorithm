import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int r, c, sum, dir;

        public Point(int r, int c, int sum, int dir) {
            this.r = r;
            this.c = c;
            this.sum = sum;
            this.dir = dir;
        }
    }

    static int N, M;
    static int[][] map;
    static int[] dr = {1, 1, 1};
    static int[] dc = {-1, 0, 1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            bfs(0, i);
        }

        System.out.println(answer);
    }

    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, map[r][c], -1));

        while (!q.isEmpty()) {
            Point p = q.poll();
            if(p.r == N-1){
                answer = Math.min(answer, p.sum);
            }

            for (int d = 0; d < 3; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (d == p.dir) continue;
                if (!isRange(nr, nc)) continue;
                q.add(new Point(nr, nc, map[nr][nc] + p.sum, d));

            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
        return false;
    }
}