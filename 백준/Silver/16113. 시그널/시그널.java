import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static int[][] zero = {{0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 2}, {3, 0}, {3, 2}, {4, 0}, {4, 1}, {4, 2}};
    static int[][] one = {{1, 0}, {2, 0}, {3, 0}, {4, 0}};
    static int[][] two = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 0}, {4, 0}, {4, 1}, {4, 2}};
    static int[][] three = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 2}, {4, 0}, {4, 1}, {4, 2}};
    static int[][] four = {{0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 2}, {4, 2}};
    static int[][] five = {{0, 1}, {0, 2}, {1, 0}, {2, 0}, {2, 1}, {2, 2}, {3, 2}, {4, 0}, {4, 1}, {4, 2}};
    static int[][] six = {{0, 1}, {0, 2}, {1, 0}, {2, 0}, {2, 1}, {2, 2}, {3, 0}, {3, 2}, {4, 0}, {4, 1}, {4, 2}};
    static int[][] seven = {{0, 1}, {0, 2}, {1, 2}, {2, 2}, {3, 2}, {4, 2}};
    static int[][] eight = {{0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 0}, {3, 2}, {4, 0}, {4, 1}, {4, 2}};
    static int[][] nine = {{0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 2}, {4, 0}, {4, 1}, {4, 2}};
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        map = new char[5][N / 5];
        v = new boolean[5][N / 5];

        String s = br.readLine();

        int idx = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < N / 5; j++) {
                map[i][j] = s.charAt(idx);
                idx++;
            }
        }

        for (int i = 0; i < N / 5; i++) {
            if (!v[0][i] && map[0][i] == '#') {
                findNum(i);
            }
        }


    }

    private static void printv() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < N / 5; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void findNum(int i) {
        if (eightCheck(i)) {
            System.out.print("8");
        } else if (nineCheck(i)) {
            System.out.print("9");
        } else if (zeroCheck(i)) {
            System.out.print("0");
        } else if (sixCheck(i)) {
            System.out.print("6");
        } else if (fiveCheck(i)) {
            System.out.print("5");
        } else if (threeCheck(i)) {
            System.out.print("3");
        } else if (fourCheck(i)) {
            System.out.print("4");
        } else if (twoCheck(i)) {
            System.out.print("2");
        } else if (sevenCheck(i)) {
            System.out.print("7");
        } else if (oneCheck(i)) {
            System.out.print("1");
        }
    }

    private static boolean nineCheck(int i) {
        for (int j = 0; j < nine.length; j++) {
            int nr = 0 + nine[j][0];
            int nc = i + nine[j][1];

            if (!isRange(nr, nc)) return false;
            if (isRange(nr, nc) && map[nr][nc] == '.') return false;

        }

        for (int j = 0; j < nine.length; j++) {
            int nr = 0 + nine[j][0];
            int nc = i + nine[j][1];

            v[nr][nc] = true;
        }
        return true;
    }


    private static boolean eightCheck(int i) {
        for (int j = 0; j < eight.length; j++) {
            int nr = 0 + eight[j][0];
            int nc = i + eight[j][1];

            if (!isRange(nr, nc)) return false;
            if (isRange(nr, nc) && map[nr][nc] == '.') return false;
        }

        for (int j = 0; j < eight.length; j++) {
            int nr = 0 + eight[j][0];
            int nc = i + eight[j][1];

            v[nr][nc] = true;
        }
        return true;
    }

    private static boolean sevenCheck(int i) {
        for (int j = 0; j < seven.length; j++) {
            int nr = 0 + seven[j][0];
            int nc = i + seven[j][1];

            if (!isRange(nr, nc)) return false;
            if (isRange(nr, nc) && map[nr][nc] == '.') return false;
        }

        for (int j = 0; j < seven.length; j++) {
            int nr = 0 + seven[j][0];
            int nc = i + seven[j][1];

            v[nr][nc] = true;
        }
        return true;
    }

    private static boolean sixCheck(int i) {
        for (int j = 0; j < six.length; j++) {
            int nr = 0 + six[j][0];
            int nc = i + six[j][1];

            if (!isRange(nr, nc)) return false;
            if (isRange(nr, nc) && map[nr][nc] == '.') return false;
        }

        for (int j = 0; j < six.length; j++) {
            int nr = 0 + six[j][0];
            int nc = i + six[j][1];

            v[nr][nc] = true;
        }
        return true;
    }

    private static boolean fiveCheck(int i) {
        for (int j = 0; j < five.length; j++) {
            int nr = 0 + five[j][0];
            int nc = i + five[j][1];

            if (!isRange(nr, nc)) return false;
            if (isRange(nr, nc) && map[nr][nc] == '.') return false;
        }

        for (int j = 0; j < five.length; j++) {
            int nr = 0 + five[j][0];
            int nc = i + five[j][1];

            v[nr][nc] = true;
        }
        return true;
    }

    private static boolean fourCheck(int i) {
        for (int j = 0; j < four.length; j++) {
            int nr = 0 + four[j][0];
            int nc = i + four[j][1];

            if (!isRange(nr, nc)) return false;
            if (isRange(nr, nc) && map[nr][nc] == '.') return false;
        }

        for (int j = 0; j < four.length; j++) {
            int nr = 0 + four[j][0];
            int nc = i + four[j][1];

            v[nr][nc] = true;
        }
        return true;
    }

    private static boolean threeCheck(int i) {
        for (int j = 0; j < three.length; j++) {
            int nr = 0 + three[j][0];
            int nc = i + three[j][1];

            if (!isRange(nr, nc)) return false;
            if (isRange(nr, nc) && map[nr][nc] == '.') return false;
        }

        for (int j = 0; j < three.length; j++) {
            int nr = 0 + three[j][0];
            int nc = i + three[j][1];

            v[nr][nc] = true;
        }
        return true;
    }

    private static boolean twoCheck(int i) {
        for (int j = 0; j < two.length; j++) {
            int nr = 0 + two[j][0];
            int nc = i + two[j][1];

            if (!isRange(nr, nc)) return false;
            if (isRange(nr, nc) && map[nr][nc] == '.') return false;
        }

        for (int j = 0; j < two.length; j++) {
            int nr = 0 + two[j][0];
            int nc = i + two[j][1];

            v[nr][nc] = true;
        }
        return true;
    }

    private static boolean oneCheck(int i) {
        for (int j = 0; j < one.length; j++) {
            int nr = 0 + one[j][0];
            int nc = i + one[j][1];

            if (!isRange(nr, nc)) return false;
            if (isRange(nr, nc) && map[nr][nc] == '.') return false;
        }

        for (int j = 0; j < one.length; j++) {
            int nr = 0 + one[j][0];
            int nc = i + one[j][1];

            v[nr][nc] = true;
        }
        return true;
    }

    private static boolean zeroCheck(int i) {
        for (int j = 0; j < zero.length; j++) {
            int nr = 0 + zero[j][0];
            int nc = i + zero[j][1];

            if (!isRange(nr, nc)) return false;
            if (isRange(nr, nc) && map[nr][nc] == '.') return false;
        }

        for (int j = 0; j < zero.length; j++) {
            int nr = 0 + zero[j][0];
            int nc = i + zero[j][1];

            v[nr][nc] = true;
        }
        return true;
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < 5 && nc >= 0 && nc < N / 5) {
            return true;
        }
        return false;
    }

    private static void print(char[][] map, int n) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n / 5; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}