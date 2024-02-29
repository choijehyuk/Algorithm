import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, tempMax;
    static int[][] map;
    static Node[] visited = new Node[4];
    static Node[] max = new Node[4];
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static final int maxVal = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 2][M + 2];

        for (int i = 0; i < N + 2; ++i) {
            for (int j = 0; j < M + 2; ++j) {
                map[i][j] = 0;
            }
        }

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= M; ++j) {
                solve(i, j, 0);
            }
        }

        int curMax = tempMax;

        for (Node cur : max) {
            map[cur.r][cur.c] -= maxVal;
        }

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= M; ++j) {
                solve(i, j, curMax);
            }
        }

        for (Node cur : max) {
            map[cur.r][cur.c] += maxVal;
        }

        Node cur = max[0];
        List<Node> adj = new ArrayList<>();

        for (int i = -7; i < 8; i++) {
            for (int j = -7; j < 8; j++) {
                if (Math.abs(i) + Math.abs(j) < 8 && 1 <= cur.r + i && cur.r + i <= N
                        && 1 <= cur.c + j && cur.c + j <= M) {
                    adj.add(new Node(cur.r + i, cur.c + j));
                }
            }
        }

        int answer = tempMax;

        for (Node node : adj) {
            tempMax = 0;
            solve(node.r, node.c, 0);
            curMax = tempMax;

            for (Node max1 : max) {
                map[max1.r][max1.c] -= maxVal;
            }

            for (Node node1 : adj) {
                solve(node1.r, node1.c, curMax);
            }

            for (Node max1 : max) {
                map[max1.r][max1.c] += maxVal;
            }

            answer = Math.max(answer, tempMax);
        }

        System.out.println(answer);

    }

    private static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int r, int c, int depth, int sum, int dir, boolean flag) {
        visited[depth - 1] = new Node(r, c);
        if (depth == 4) {
            if (tempMax < sum) {
                tempMax = sum;
                if (flag) {
                    for (int i = 0; i < 4; i++) {
                        max[i] = visited[i];
                    }
                }
            }
            return;
        }
        for (int d = 0; d < 4; ++d) {
            if (d == dir) {
                continue;
            }
            int nr = r + dr[d];
            int nc = c + dc[d];

            int oppositeDir = (d + 2) % 4;

            if (map[nr][nc] != 0) {
                dfs(nr, nc, depth + 1, sum + map[nr][nc], oppositeDir, flag);
            }
        }
    }

    static void solve(int r, int c, int sum) {
        boolean flag = false;

        if (sum == 0) flag = true;

        sum += map[r][c];
        dfs(r, c, 1, sum, -1, flag);

        int minVal = maxVal, minDir = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            sum += map[nr][nc];

            if (minVal > map[nr][nc]) {
                minVal = map[nr][nc];
                minDir = d;
            }
            visited[d] = new Node(nr, nc);
        }
        visited[minDir] = new Node(r, c);
        if (tempMax < sum - minVal) {
            tempMax = sum - minVal;

            if (flag) {
                for (int i = 0; i < 4; i++) {
                    max[i] = visited[i];
                }
            }
        }
    }

}