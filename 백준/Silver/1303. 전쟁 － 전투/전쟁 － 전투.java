import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static char[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int blueSum, whiteSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        v = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) bfs(i, j);
            }
        }

        System.out.println(whiteSum + " " + blueSum);

    }

    private static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        v[r][c] = true;

        char color = map[r][c];

        int cnt = 1;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isRange(nr, nc)) continue;
                if (map[nr][nc] != color) continue;
                if (v[nr][nc]) continue;

                q.add(new Node(nr, nc));
                v[nr][nc] = true;
                cnt++;
            }
        }

        int cal = (int) Math.pow(cnt, 2);
        if (color == 'W') whiteSum += cal;
        else if (color == 'B') blueSum += cal;

    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < M && nc >= 0 && nc < N) return true;
        return false;
    }
}