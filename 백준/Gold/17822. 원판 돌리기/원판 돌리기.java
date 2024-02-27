import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, T;
    static int x, d, k;
    static int[][] map;
    static boolean isChange;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            isChange = false;

            int idx = 1;
            while (true) {
                int mul = x * idx - 1;
                if (mul >= N) break;
                rotation(mul);
                idx++;
            }

            for (int j = 0; j < N; j++) {
                for (int l = 0; l < M; l++) {
                    if (map[j][l] != 0) near(j, l);
                }
            }

            if (!isChange) avgChange();
            
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer += map[i][j];
            }
        }
        System.out.println(answer);

    }

    private static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void avgChange() {

        double cnt = 0;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;
                cnt++;
                sum += map[i][j];
            }
        }

        double avg = sum / cnt;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;
                if (map[i][j] > avg) map[i][j]--;
                else if (map[i][j] < avg) map[i][j]++;
            }
        }
    }

    private static void near(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] v = new boolean[N][M];
        v[r][c] = true;
        q.add(new Point(r, c));
        int first = map[r][c];

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = p.r + dr[dir];
                int nc = (p.c + dc[dir] + M) % M;

                if (nr < 0 || nr >= N) continue;

                if (map[nr][nc] == first && !v[nr][nc] && map[nr][nc] != 0) {
                    map[r][c] = 0;
                    q.add(new Point(nr, nc));
                    map[nr][nc] = 0;
                    v[nr][nc] = true;
                    isChange = true;
                }
            }
        }
    }

    private static void rotation(int mul) {
        int rot = k;
        if (d == 1) rot = M - k;

        while (rot > 0) {
            int temp = map[mul][M - 1];

            for (int i = M - 1; i > 0; i--) {
                map[mul][i] = map[mul][i - 1];
            }
            map[mul][0] = temp;
            rot--;
        }
    }
}