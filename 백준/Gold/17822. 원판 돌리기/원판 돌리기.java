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

        //print(map);

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            isChange = false;

            // x의 배수
            // d방향으로 k칸 회전
            // 0이면 시계 1이면 반시계

            int idx = 1;
            while (true) {
                int mul = x * idx - 1;
                if (mul >= N) break;
                rotation(mul);
                idx++;
            }

//            System.out.println("---rotation start---");
//            print(map);


            for (int j = 0; j < N; j++) {
                for (int l = 0; l < M; l++) {
                    if (map[j][l] != 0) near(j, l);
                }
            }

//            System.out.println("--near start ---");
//            print(map);

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
// 0
                if (nr < 0 || nr >= N) continue;

//                if(!isRange(nr,nc)) {
//                    // 0일때 위에서 아래로
//                    if(nc < 0){
//                        if(map[nr][M-1] == map[p.r][p.c] && !v[nr][M-1]){
//                            q.add(new Point(nr, M-1));
//                            map[nr][M-1] = 0;
//                            v[nr][M-1] = true;
//                        }
//                    }
//                    // M 일때 아래에서 위로
//                    else if(nc >= M){
//                        if(map[nr][0] == map[p.r][p.c] && !v[nr][0]){
//                            q.add(new Point(nr,0));
//                            map[nr][0] = 0;
//                            v[nr][0] = true;
//                        }
//                    }
//                }

//                System.out.println(p.r + " " + p.c + " " + nr + " " + nc);
//                System.out.println();

                if (map[nr][nc] == first && !v[nr][nc] && map[nr][nc] != 0) {
                    map[r][c] = 0;
                    q.add(new Point(nr, nc));
                    map[nr][nc] = 0;
                    v[nr][nc] = true;
                    isChange = true;
//                    System.out.println("remove === ");
//                    print(map);
//                    System.out.println();
                }


            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
        return false;
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