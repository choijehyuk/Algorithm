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

    static int N, M;
    static char[][] map;
    static boolean[][] v;
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
                if (dfs(i, j)) answer++;
            }
        }

        //print(map);

        System.out.println(answer);
    }

    private static void print(char[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean dfs(int r, int c) {
        boolean flag = false;
        if (!isRange(r, c)) return true;

        if (map[r][c] == 'T') return true;
        else if (map[r][c] == 'F') return false;

        if (v[r][c]) return false;

        v[r][c] = true;
        int nr = 0;
        int nc = 0;

        switch (map[r][c]) {
            case 'U':
                nr = r + dr[0];
                nc = c + dc[0];
                break;
            case 'R':
                nr = r + dr[1];
                nc = c + dc[1];
                break;
            case 'D':
                nr = r + dr[2];
                nc = c + dc[2];
                break;
            case 'L':
                nr = r + dr[3];
                nc = c + dc[3];
                break;
        }

        flag = dfs(nr, nc);
        if (flag) map[r][c] = 'T';
        else map[r][c] = 'F';
        return flag;
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
        return false;
    }
}