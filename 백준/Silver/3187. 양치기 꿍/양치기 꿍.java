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

    static int R, C;
    static char[][] map;
    static boolean[][] v;
    static int sheep;
    static int wolf;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int livesheep;
    static int livewolf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        v = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        //print(map);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !v[i][j])
                    bfs(i, j);
            }
        }

        System.out.println(livesheep + " " + livewolf);
    }

    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));
        v[r][c] = true;
        sheep = 0;
        wolf = 0;

        if(map[r][c] == 'k'){
            sheep++;
        }
        else if(map[r][c] == 'v'){
            wolf++;
        }

        while(!q.isEmpty()){
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr >= 0 && nr < R && nc >= 0 && nc < C && !v[nr][nc] && map[nr][nc] != '#'){
                    v[nr][nc] = true;
                    q.add(new Point(nr,nc));
                    if(map[nr][nc] == 'k'){
                        sheep++;
                    }
                    else if(map[nr][nc] == 'v'){
                        wolf++;
                    }
                }
            }
        }
        live();

    }

    private static void live() {
        if(sheep > wolf){
            livesheep += sheep;
        }
        else{
            livewolf += wolf;
        }
    }

    private static void print(char[][] map) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}