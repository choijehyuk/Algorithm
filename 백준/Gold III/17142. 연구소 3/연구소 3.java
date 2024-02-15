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

    static int N, M, time, virusCnt, min;

    static int map[][];
    static int[] numbers;
    static List<Point> list;
    static boolean visited[][];
    static Queue<Point> q;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int zeroCnt;
    static int check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        numbers = new int[M];
        list = new ArrayList<>();

        virusCnt = 0;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    list.add(new Point(i, j));
                    virusCnt++;
                }
                if (map[i][j] == 0) zeroCnt++;
            }
        }

        comb(0, 0);

        min = Math.min(min, time);
        System.out.println(min);
    }

    private static void comb(int cnt, int start) {
        if (cnt == M) {
            visited = new boolean[N][N];
            q = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 2) {
                        map[i][j] = 3;
                    }
                }
            }
            check = 0;

            for (int i = 0; i < M; i++) {
                //System.out.println(list.get(numbers[i]).r + " " + list.get(numbers[i]).c);
                q.offer(list.get(numbers[i]));
                map[list.get(numbers[i]).r][list.get(numbers[i]).c] = 2;
                visited[list.get(numbers[i]).r][list.get(numbers[i]).c] = true;
            }
            bfs();
            return;
        }

        for (int i = start; i < virusCnt; i++) {
            numbers[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    private static void bfs() {
        time = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Point p = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = p.r + dr[d];
                    int nc = p.c + dc[d];

                    if (!isRange(nr, nc)) continue;
                    if (map[nr][nc] == 1 || visited[nr][nc]) continue;

                    if (map[nr][nc] == 0) {
                        //System.out.println(nr + " " + nc + " nrnc");
                        check++;
                    }
                    q.offer(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
            //System.out.println(check);
            time++;
            //System.out.println(time);
            if (check == zeroCnt) {
                //System.out.println("end ------------------" + time);
                break;
            }
        }

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 1 && !visited[i][j] && map[i][j] != 3) {
                    flag = true;
                    break;
                }
            }
        }
        //System.out.println(flag);
        //System.out.println("-----------");

        int end = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    end++;
                }
            }
        }
        if (end == 0) time = 0;

        if (flag)
            if (min == Integer.MAX_VALUE) {
                time = -1;
            }

        if (!flag) {
            min = Math.min(min, time);

        }

    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
        return false;
    }
}