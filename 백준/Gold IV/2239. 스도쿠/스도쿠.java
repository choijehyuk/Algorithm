import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;

        }
    }

    static int[][] map;
    static ArrayList<Point> list;
    static boolean end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        map = new int[9][9];
        list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = s.charAt(j) - 48;
                if (map[i][j] == 0) {
                    list.add(new Point(i, j));
                }
            }
        }

        dfs(0);

        print(map);

    }

    private static void dfs(int idx) {
        if (idx == list.size()) {
            end = true;
            return;
        }

        Point p = list.get(idx);

        for (int i = 1; i <= 9; i++) {
            map[p.r][p.c] = i;

            if (isSquare(p.r, p.c) && isRow(p.r, p.c) && isCol(p.r, p.c)) {
                dfs(idx + 1);
            }
            if (end) return;
            map[p.r][p.c] = 0;
        }

    }

    private static boolean isCol(int r, int c) {
        for (int i = 0; i < 9; i++) {
            if (i == r) continue;
            if (map[i][c] == map[r][c]) return false;
        }
        return true;
    }

    private static boolean isRow(int r, int c) {
        for (int i = 0; i < 9; i++) {
            if (i == c) continue;
            if (map[r][i] == map[r][c]) return false;
        }
        return true;
    }

    private static boolean isSquare(int r, int c) {
        int nr = (r / 3) * 3;
        int nc = (c / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (nr + i == r && nc + j == c) continue;
                if (map[nr + i][nc + j] == map[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void print(int[][] map) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}