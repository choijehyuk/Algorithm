import java.util.*;
import java.io.*;
class Solution {
    static class Node {
        int r,c,cnt;
        public Node(int r, int c, int cnt) {
            this.r = r; this.c = c; this.cnt = cnt;
        }
    }
    static int[][] map = new int[101][101];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] ddr = {-1,-1,0,1,1,1,0,-1};
    static int[] ddc = {0,1,1,1,0,-1,-1,-1};
    static int ans = 0;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rect : rectangle) {
            int leftX = rect[0] * 2;
            int leftY = rect[1] * 2;
            int rightX = rect[2] * 2;
            int rightY = rect[3] * 2;

            for (int j = leftY; j <= rightY; j++) {
                for (int k = leftX; k <= rightX; k++) {
                    map[j][k] += 1;
                }
            }
        }

        bfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2);

        return ans / 2; 
    }

    public static void bfs(int r, int c, int targetR, int targetC) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c, 0));
        boolean[][] v = new boolean[101][101];
        v[r][c] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.r == targetR && cur.c == targetC) {
                ans = cur.cnt;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isRange(nr, nc)) continue;
                if (v[nr][nc]) continue;
                if (map[nr][nc] == 0) continue;
                if (!isSide(nr, nc)) continue;

                q.add(new Node(nr, nc, cur.cnt + 1));
                v[nr][nc] = true;
            }
        }
    }

    public static boolean isSide(int r, int c) {
        for (int d = 0; d < 8; d++) {
            int nr = r + ddr[d];
            int nc = c + ddc[d];
            if (!isRange(nr, nc)) return true;
            if (map[nr][nc] == 0) return true;
        }
        return false;
    }

    public static boolean isRange(int r, int c) {
        return r >= 0 && r <= 100 && c >= 0 && c <= 100;
    }
}