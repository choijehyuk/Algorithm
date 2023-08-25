import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static char[][] map;
    static boolean[][] v;
    static int answer;
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

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!v[i][j]) {
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
        answer++;

        if (map[r][c] == '-') {
            while (!q.isEmpty()) {
                Point p = q.poll();

                while (c < M) {
                    if (map[r][c] == '-') {
                        v[r][c] = true;
                        q.add(new Point(r, c));
                    } else {
                        break;
                    }
                    c++;
                }
            }
        } else if (map[r][c] == '|') {
            while (!q.isEmpty()) {
                Point p = q.poll();

                while (r < N) {
                    if (map[r][c] == '|') {
                        v[r][c] = true;
                        q.add(new Point(r, c));
                    } else {
                        break;
                    }
                    r++;
                }
            }
        }
    }
}
