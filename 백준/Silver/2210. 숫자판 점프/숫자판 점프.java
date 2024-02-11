import java.util.*;
import java.io.*;

public class Main {

    static String[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        map = new String[5][5];
        set = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = st.nextToken();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, map[i][j]);
            }
        }

        System.out.println(set.size());
    }

    private static void dfs(int r, int c, int cnt, String word) {
        if (cnt == 5) {
            if (!set.contains(word)) {
                set.add(word);
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!isRange(nr, nc)) continue;
            dfs(nr, nc, cnt + 1, word + map[nr][nc]);
        }
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) return true;
        return false;
    }
}