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
    static int[][] value;
    static HashSet<Integer> set;
    static ArrayList<Integer> list;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int index = 0;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M];
        value = new int[N][M];
        set = new HashSet<>();
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!v[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    int sum = 0;
                    set.clear();
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (isRange(nr, nc) && map[nr][nc] == 1) {
                            if (set.contains(value[nr][nc])) continue;
                            sum += list.get(value[nr][nc]);
                            set.add(value[nr][nc]);
                        }
                    }
                    answer = Math.max(answer, sum);
                }
            }
        }

        System.out.println(++answer);

    }

    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        v[r][c] = true;
        int cnt = 0;
        value[r][c] = index;

        while (!q.isEmpty()) {
            Point p = q.poll();

            cnt++;
            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (!isRange(nr, nc)) continue;

                if (map[nr][nc] == 1 && !v[nr][nc]) {
                    q.add(new Point(nr, nc));
                    value[nr][nc] = index;
                    v[nr][nc] = true;
                }
            }
        }

        list.add(cnt);
        index++;
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
        return false;
    }
}