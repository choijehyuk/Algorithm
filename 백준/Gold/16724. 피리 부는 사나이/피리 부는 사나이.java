import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static boolean[][] end;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }


        v = new boolean[N][M];
        end = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!v[i][j]) {
                    dfs(i, j);
                }
            }
        }
        //print(map);

        System.out.println(answer);

    }

    private static void print(int[][] val) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(val[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int r, int c) {
        v[r][c] = true;

        int nr = 0;
        int nc = 0;
        switch (map[r][c]) {
            case 'U':
                nr = r + dr[0];
                nc = c + dc[0];
                break;
            case 'R':
                nr = r + dr[1];
                nc = c + dc[1];
                break;
            case 'D':
                nr = r + dr[2];
                nc = c + dc[2];
                break;
            case 'L':
                nr = r + dr[3];
                nc = c + dc[3];
                break;
        }

        if (!v[nr][nc]) {
            dfs(nr, nc);
        } else {
            if (!end[nr][nc]) answer++;
        }

        end[r][c] = true;

    }
}