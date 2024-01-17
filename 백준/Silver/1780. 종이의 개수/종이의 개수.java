import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    static int N;
    static int[][] map;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = new int[3];
        // -1 0 1

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursive(0, 0, N);

        for (int i = 0; i < 3; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void recursive(int r, int c, int size) {
        if (check(r, c, size)) {
            if (map[r][c] == -1) answer[0]++;
            else if (map[r][c] == 0) answer[1]++;
            else if (map[r][c] == 1) answer[2]++;
            return;
        }

        int div = size / 3;
        for (int i = r; i < r + size; i += div) {
            for (int j = c; j < c + size; j += div) {
                recursive(i, j, div);
            }
        }
    }

    private static boolean check(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] != map[r][c]) return false;
            }
        }
        return true;
    }

}