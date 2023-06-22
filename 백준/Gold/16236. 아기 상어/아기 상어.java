import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int r, c, time;

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int sharkX, sharkY;
    static int sharkSize = 2;
    static int eatCnt;
    static boolean endCheck = true;
    static int answer;
    static int dist, pr, pc;
    static int endCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }

            }
        }

        while (true) {
            bfs(sharkX, sharkY, 0);

//            print(map);
//            System.out.println("---------");
            if (eatCnt == sharkSize) {
                sharkSize++;
                eatCnt = 0;
            }

            endCheck = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != 0 && map[i][j] < sharkSize){
                        endCheck = false;

                    }
                }
            }

            if(endCnt > 100000){
                endCheck = true;
            }

            if (endCheck) break;

            // 먹을 수 있는 물고기가 있는데 가지 못할때 끝내야함

        }

        System.out.println(answer);


    }

    private static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int r, int c, int time) {
        Queue<Point> q = new LinkedList<>();
        v = new boolean[N][N];
        q.add(new Point(r, c, time));
        v[r][c] = true;
        endCnt ++;
        while (!q.isEmpty()) {
            if (dist != 0) {
                map[pr][pc] = 0;
                eatCnt++;
                sharkX = pr;
                sharkY = pc;
                answer += dist;
                dist = 0;
                break;
            }
            int size = q.size();
            dist = 0;
            pr = 0;
            pc = 0;

            for (int i = 0; i < size; i++) {
                Point p = q.poll();
                if (map[p.r][p.c] != 0 && map[p.r][p.c] < sharkSize) {
                    if (dist == 0 || (p.time == dist && (p.r < pr || (p.r == pr && p.c < pc)))) {
                        pr = p.r;
                        pc = p.c;
                        dist = p.time;
                    }
                }
                for (int d = 0; d < 4; d++) {
                    int nr = p.r + dr[d];
                    int nc = p.c + dc[d];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] <= sharkSize) {
                        v[nr][nc] = true;
                        q.add(new Point(nr, nc, p.time + 1));
                    }
                }
            }
        }
    }
}