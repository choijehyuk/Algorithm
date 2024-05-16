import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, move;

        public Node(int r, int c, int move) {
            this.r = r;
            this.c = c;
            this.move = move;
        }
    }
    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int max = Integer.MIN_VALUE;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    v = new boolean[N][M];
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);

    }

    private static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        v[r][c] = true;
        q.add(new Node(r, c, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.move >= max) {
                if (cur.move > max) answer = map[r][c] + map[cur.r][cur.c];
                else answer = Math.max(answer, map[r][c] + map[cur.r][cur.c]);
                max = cur.move;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isRange(nr, nc)) continue;
                if (v[nr][nc]) continue;
                if (map[nr][nc] == 0) continue;

                q.add(new Node(nr, nc, cur.move + 1));
                v[nr][nc] = true;
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
        return false;
    }
}