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

    static int N, K;
    static int S, X, Y;
    static int[][] map;
    static boolean[][] v;
    static int answer = Integer.MAX_VALUE;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        v = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;


        bfs(X, Y, 0);

        if (map[X][Y] != 0) {
            System.out.println(map[X][Y]);
            System.exit(0);
        }

        //print(map);
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }

    private static void bfs(int r, int c, int cnt) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, cnt));
        v[r][c] = true;

        int end = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.cnt == S) {
                break;
            }

            if(answer != Integer.MAX_VALUE && p.cnt != end){
                break;
            }


            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
                    if (map[nr][nc] != 0) {
                        answer = Math.min(map[nr][nc], answer);
                    }

                    q.add(new Point(nr, nc, p.cnt + 1));
                }
            }

            if(answer != Integer.MAX_VALUE){
                end = p.cnt;
            }

        }
    }

    private static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}