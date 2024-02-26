import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int r, c, dir;

        public Point(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    static int A, B;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        boolean[][] v = new boolean[B][A];
        // 4 x 5

        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            x -= 1;
            y = B - y;

            int d = -1;
            if (dir.equals("N")) d = 0;
            else if (dir.equals("E")) d = 1;
            else if (dir.equals("S")) d = 2;
            else if (dir.equals("W")) d = 3;

            list.add(new Point(y, x, d));
            v[y][x] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int robot = Integer.parseInt(st.nextToken()) - 1;
            String order = st.nextToken();
            int times = Integer.parseInt(st.nextToken());

            int nr = 0;
            int nc = 0;
            v[list.get(robot).r][list.get(robot).c] = false;

            for (int j = 0; j < times; j++) {
                int r = list.get(robot).r;
                int c = list.get(robot).c;
                int dir = list.get(robot).dir;

                if (order.equals("L")) {
                    dir += 3;
                    dir %= 4;
                    list.get(robot).dir = dir;
                } else if (order.equals("R")) {
                    dir += 1;
                    dir %= 4;
                    list.get(robot).dir = dir;
                } else if (order.equals("F")) {
                    nr = r + dr[dir];
                    nc = c + dc[dir];

                    if (!isRange(nr, nc)) {
                        System.out.println("Robot " + (robot + 1) + " crashes into the wall");
                        System.exit(0);
                    }

                    if (v[nr][nc]) {
                        for (int k = 0; k < list.size(); k++) {
                            if (list.get(k).r == nr && list.get(k).c == nc) {
                                System.out.println("Robot " + (robot + 1) + " crashes into robot " + (k + 1));
                                System.exit(0);
                            }
                        }
                    }

                    list.get(robot).r = nr;
                    list.get(robot).c = nc;
                }
            }

            v[nr][nc] = true;

        }
        System.out.println("OK");
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < B && nc >= 0 && nc < A) return true;
        return false;
    }
}