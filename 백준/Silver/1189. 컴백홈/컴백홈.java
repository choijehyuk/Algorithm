import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int R, C, K;
    static char[][] map;
    static int ans;
    static int tr, tc;
    static boolean[][] v;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        v = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'T') {
                    tr = i;
                    tc = j;
                }
            }
        }

        v[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(ans);
    }

    private static void dfs(int r, int c, int cnt) {
        if (r == 0 && c == C - 1) {
            if (cnt == K) ans++;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!isRange(nr, nc)) continue;
            if (map[nr][nc] == 'T') continue;
            if (v[nr][nc]) continue;

            v[nr][nc] = true;
            dfs(nr, nc, cnt + 1);
            v[nr][nc] = false;
        }
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < R && nc >= 0 && nc < C;
    }


}