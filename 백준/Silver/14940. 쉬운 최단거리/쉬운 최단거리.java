import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static int[][] map;
    static int[][] answermap;
    static boolean[][] v;
    static int endX, endY;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        answermap = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    endX = i;
                    endY = j;
                }
            }
        }

        bfs(endX, endY,0);

        print(answermap);

    }

    private static void bfs(int r, int c, int cnt) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c,cnt));
        v[r][c] = true;

        while(!q.isEmpty()){
            Point p = q.poll();

            answermap[p.r][p.c] = p.cnt;

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] != 0){
                    q.add(new Point(nr,nc,p.cnt+1));
                    v[nr][nc] = true;
                }

                else if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0){
                    v[nr][nc] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!v[i][j] && map[i][j] == 1){
                    answermap[i][j] = -1;
                }
            }
        }
    }

    private static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
