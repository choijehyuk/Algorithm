import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int minX = Integer.MAX_VALUE;
    static int minY = Integer.MAX_VALUE;
    static int maxX, maxY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
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

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                boolean flag = check(i, j);

                if (map[i][j] == '.') flag = true;

                if (flag) v[i][j] = true;
                else {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }


        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                if (v[i][j]) map[i][j] = '.';
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean check(int r, int c) {
        int cnt = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!isRange(nr, nc)) {
                cnt++;
                continue;
            }

            if (map[nr][nc] == '.') cnt++;

        }

        if (cnt >= 3) return true;
        else return false;
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
        return false;
    }

}