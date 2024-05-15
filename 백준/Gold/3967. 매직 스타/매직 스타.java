import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] eng;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = 5;
        M = 9;
        eng = new boolean[12];
        arr = new int[6][4];

        arr[0] = new int[]{0, 2, 5, 7};
        arr[1] = new int[]{0, 3, 6, 10};
        arr[2] = new int[]{1, 2, 3, 4};
        arr[3] = new int[]{1, 5, 8, 11};
        arr[4] = new int[]{4, 6, 9, 11};
        arr[5] = new int[]{7, 8, 9, 10};


        String str = "";

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);

                if (c != '.') {
                    str += c;
                    if (c != 'x') eng[c - 'A'] = true;
                }
            }
        }

        dfs(0, str);

    }

    private static void dfs(int depth, String str) {

        if (depth == 12) {
            if (calSum(str)) {
                print(str);
                System.exit(0);
            }
            return;
        }

        if (str.charAt(depth) != 'x') dfs(depth + 1, str);
        else {

            StringBuilder sb = new StringBuilder(str);

            for (int i = 0; i < 12; i++) {
                if (!eng[i]) {
                    eng[i] = true;
                    sb.replace(depth, depth + 1, String.valueOf((char) (i + 'A')));
                    dfs(depth + 1, sb.toString());
                    sb.replace(depth, depth + 1, String.valueOf('x'));
                    eng[i] = false;
                }
            }
        }

    }

    private static void print(String s) {
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], '.');
        }

        map[0][4] = s.charAt(0);
        map[1][1] = s.charAt(1);
        map[1][3] = s.charAt(2);
        map[1][5] = s.charAt(3);
        map[1][7] = s.charAt(4);
        map[2][2] = s.charAt(5);
        map[2][6] = s.charAt(6);
        map[3][1] = s.charAt(7);
        map[3][3] = s.charAt(8);
        map[3][5] = s.charAt(9);
        map[3][7] = s.charAt(10);
        map[4][4] = s.charAt(11);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    private static boolean calSum(String str) {

        for (int i = 0; i < 5; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += str.charAt(arr[i][j]);
            }

            if (sum != 282) return false;
        }

        return true;
    }
}