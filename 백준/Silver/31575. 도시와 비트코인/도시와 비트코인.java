import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static class Node {
        int r, c, cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static int[][] map;

    static int[] dr = {1, 0};
    static int[] dc = {0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(N == 1 && M == 1) {
            System.out.println("Yes");
            System.exit(0);
        }

//        print(map);

        bfs();

        System.out.println("No");

    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        boolean[][] v = new boolean[N][M];
        v[0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 2; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isRange(nr, nc)) continue;
                if (v[nr][nc]) continue;
                if(map[nr][nc] == 0) continue;

                if (nr == N - 1 && nc == M - 1) {
                    System.out.println("Yes");
                    System.exit(0);
                }

                v[nr][nc] = true;
                q.add(new Node(nr, nc, cur.cnt + 1));
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
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