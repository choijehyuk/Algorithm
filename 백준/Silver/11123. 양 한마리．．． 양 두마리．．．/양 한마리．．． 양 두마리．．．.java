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
    static int T,H,W;
    static char[][] map;
    static boolean[][] v;
    static int answer;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            v = new boolean[H][W];
            answer = 0;

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if(map[i][j] == '#' && !v[i][j]){
                        bfs(i,j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }


    }

    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));
        v[r][c] = true;

        while(!q.isEmpty()){
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr >= 0 && nr < H && nc >= 0 && nc < W && !v[nr][nc] && map[nr][nc] == '#'){
                    v[nr][nc] = true;
                    q.add(new Point(nr,nc));
                }
            }
        }
    }
}
