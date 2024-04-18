import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                solve(i, j);
            }
        }

        System.out.println(answer);

    }

    private static void solve(int r, int c) {
        char color = map[r][c];

        // 세로
        boolean flag = false;
        int nr = r;
        int cnt = 1;
        while (nr < N - 1) {
            nr++;

            if (map[nr][c] != color && flag) break;

            if (map[nr][c] == color) cnt++;

            else if (map[nr][c] != color && !flag) {
                if (isRange(nr, c + 1) && map[nr][c + 1] == color) {
                    flag = true;
                    cnt++;
                } else if (isRange(nr, c - 1) && map[nr][c - 1] == color) {
                    flag = true;
                    cnt++;
                }
            }

            boolean check = false;

            if (map[nr][c] != color) {
                if (isRange(nr, c + 1)) {
                    if (map[nr][c + 1] == color) check = true;
                }
                if (isRange(nr, c - 1)) {
                    if (map[nr][c - 1] == color) check = true;
                }
            } else check = true;

            if (!check) break;
        }

        if (!flag) {
            if (isRange(r - 1, c - 1) && map[r - 1][c - 1] == color) {
                cnt++;
            } else if (isRange(r - 1, c + 1) && map[r - 1][c + 1] == color) {
                cnt++;
            } else if (isRange(r - 2, c) && map[r - 2][c] == color) {
                cnt++;
            }
        }

        answer = Math.max(cnt, answer);

        // 가로
        flag = false;
        int nc = c;
        cnt = 1;
        while (nc < N - 1) {
            nc++;

            if (map[r][nc] != color && flag) break;

            if (map[r][nc] == color) cnt++;

            else if (map[r][nc] != color && !flag) {
                if (isRange(r + 1, nc) && map[r + 1][nc] == color) {
                    flag = true;
                    cnt++;
                } else if (isRange(r - 1, nc) && map[r - 1][nc] == color) {
                    flag = true;
                    cnt++;
                }
            }

            boolean check = false;
            if (map[r][nc] != color) {
                if (isRange(r + 1, nc)) {
                    if (map[r + 1][nc] == color) check = true;
                }
                if (isRange(r - 1, nc)) {
                    if (map[r - 1][nc] == color) check = true;
                }
            } else check = true;

            if (!check) break;
        }

        if (!flag) {
            if (isRange(r + 1, c - 1) && map[r + 1][c - 1] == color) {
                cnt++;
            } else if (isRange(r - 1, c - 1) && map[r - 1][c - 1] == color) {
                cnt++;
            } else if (isRange(r, c - 2) && map[r][c - 2] == color) {
                cnt++;
            }
        }
        answer = Math.max(cnt, answer);

    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
        return false;
    }

}