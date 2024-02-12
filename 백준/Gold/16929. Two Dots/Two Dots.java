import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] v;
    static int startX, startY;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

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

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (v[i][j]) continue;
                startX = i;
                startY = j;
                dfs(i, j, map[i][j], 1);
            }
        }
        System.out.println("No");

    }

    private static void dfs(int r, int c, char color, int cnt) {
        if (cnt >= 4 && r == startX && c == startY) {
            System.out.println("Yes");
            System.exit(0);
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!isRange(nr, nc)) continue;
            if (v[nr][nc]) continue;
            if (color != map[nr][nc]) continue;

            v[nr][nc] = true;
            dfs(nr, nc, color, cnt + 1);
            v[nr][nc] = false;
        }
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
        return false;
    }
}