import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int r, c, wall;

        public Node(int r, int c, int wall) {
            this.r = r;
            this.c = c;
            this.wall = wall;
        }

        @Override
        public int compareTo(Node o) {
            return this.wall - o.wall;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        //print(map);

        bfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void bfs(int r, int c, int wall) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(r, c, wall));
        v[r][c] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.r == N - 1 && cur.c == M - 1) {
                answer = cur.wall;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isRange(nr, nc)) continue;
                if (!v[nr][nc] && map[nr][nc] == 0) {
                    q.add(new Node(nr, nc, cur.wall));
                    v[nr][nc] = true;
                }

                if (!v[nr][nc] && map[nr][nc] == 1) {
                    q.add(new Node(nr, nc, cur.wall + 1));
                    v[nr][nc] = true;
                }
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
        return false;
    }

    private static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}