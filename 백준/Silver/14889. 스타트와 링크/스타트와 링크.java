import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] v;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
        //print(map);
    }

    private static void dfs(int depth, int idx) {
        if (depth == N / 2) {
            cal();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                dfs(depth + 1, i + 1);
                v[i] = false;
            }
        }
    }

    private static void cal() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (v[i] && v[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (!v[i] && !v[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        int diff = Math.abs(start - link);
        if (diff == 0) {
            System.out.println(diff);
            System.exit(0);
        }

        min = Math.min(diff, min);
    }

    private static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}