import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static int N;
    static int[][] map;
    static boolean[][] v;
    static int answer;
    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};
    static int startX, startY;
    static int endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        v = new boolean[N][N];

        st = new StringTokenizer(br.readLine());

        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());

        bfs(startX, startY,0);

        System.out.println(-1);
    }

    private static void bfs(int r, int c, int cnt) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c,cnt));
        v[r][c] = true;

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.r == endX && p.c == endY){
                System.out.println(p.cnt);
                System.exit(0);
            }
            for (int d = 0; d < 6; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]){
                    q.add(new Point(nr,nc,p.cnt+1));
                    v[nr][nc] = true;
                }
            }
        }
    }
}
