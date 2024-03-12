import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int r, c, dir, mirror;

        public Node(int r, int c, int dir, int mirror) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.mirror = mirror;
        }

        @Override
        public int compareTo(Node o) {
            return this.mirror - o.mirror;
        }
    }

    static int W, H;
    static char[][] map;
    static int[][][] v;
    static int startX, startY;
    static int endX, endY;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        v = new int[H][W][4];
        boolean flag = false;

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j);
                Arrays.fill(v[i][j], Integer.MAX_VALUE);
                if (!flag && map[i][j] == 'C') {
                    startX = i;
                    startY = j;
                    flag = true;
                }
                if (flag && map[i][j] == 'C') {
                    endX = i;
                    endY = j;
                }
            }
        }

        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(startX, startY, -5, -1));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.r == endX && cur.c == endY) {
                answer = Math.min(answer, cur.mirror);
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isRange(nr, nc)) continue;
                if (map[nr][nc] == '*') continue;

                int curMirror = cur.mirror;
                if (cur.dir != d) curMirror++;
                if (v[nr][nc][d] <= curMirror) continue;

                v[nr][nc][d] = curMirror;
                q.add(new Node(nr, nc, d, curMirror));

            }

        }
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < H && nc >= 0 && nc < W) return true;
        return false;
    }

}