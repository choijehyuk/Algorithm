import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        v = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int sum) {
        if (depth == 3) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isBlossom(i, j)) {
                    int cal = getSum(i, j);
                    visit(i, j, true);
                    dfs(depth + 1, sum + cal);
                    visit(i, j, false);
                }
            }
        }
    }

    private static void visit(int r, int c, boolean flag) {
        if (flag) {
            v[r][c] = true;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                v[nr][nc] = true;
            }
        } else {
            v[r][c] = false;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                v[nr][nc] = false;
            }
        }
    }

    private static int getSum(int r, int c) {
        int sum = map[r][c];

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            sum += map[nr][nc];
        }
        return sum;
    }

    private static boolean isBlossom(int r, int c) {
        if (v[r][c]) return false;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!isRange(nr, nc)) return false;
            if (v[nr][nc]) return false;
        }

        return true;
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
        return false;
    }
}