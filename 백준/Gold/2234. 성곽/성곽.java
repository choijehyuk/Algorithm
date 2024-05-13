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
    static int[][][] map;
    static boolean[][] v;
    static int[][] val;
    static int[] dr = {1, 0, -1, 0}; // 남 동 북 서
    static int[] dc = {0, 1, 0, -1};
    static int room;
    static int idx = 1;
    static ArrayList<Integer> list;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M][4];
        v = new boolean[N][M];
        val = new int[N][M];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());

                String bit = Integer.toBinaryString(num);

                int minus = 4 - bit.length();

                String change = "";

                for (int k = 0; k < minus; k++) {
                    change += "0";
                }
                change += bit;

                for (int k = 0; k < change.length(); k++) {
                    map[i][j][k] = Integer.parseInt(String.valueOf(change.charAt(k)));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!v[i][j]) {
                    bfs(i, j);

                    //printv();
                    room++;
                    idx++;
                }
            }
        }

        int maxsize = breakWall();
        
        System.out.println(room);
        System.out.println(max);
        System.out.println(maxsize);

    }

    private static int breakWall() {
        int maxSize = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = val[i][j];
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (!isRange(nr, nc)) continue;
                    if (num == val[nr][nc]) continue;

                    int sum = list.get(num - 1) + list.get(val[nr][nc] - 1);
                    maxSize = Math.max(maxSize, sum);
                }

            }
        }

        return maxSize;
    }

    private static void printv() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        v[r][c] = true;

        int size = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isRange(nr, nc)) continue;
                if (map[cur.r][cur.c][d] == 1) continue;
                if (v[nr][nc]) continue;

                q.add(new Node(nr, nc));
                v[nr][nc] = true;
            }
            size++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (v[i][j] && val[i][j] == 0) {
                    val[i][j] = idx;
                }
            }
        }

        list.add(size);

        max = Math.max(size, max);
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
        return false;
    }
}
