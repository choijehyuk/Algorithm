import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int redr, redc, bluer, bluec, cnt;

        public Node(int redr, int redc, int bluer, int bluec, int cnt) {
            this.redr = redr;
            this.redc = redc;
            this.bluer = bluer;
            this.bluec = bluec;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static char[][] map;
    static boolean[][][][] v;
    static int blueX, blueY;
    static int redX, redY;
    static int endX, endY;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        v = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'B') {
                    blueX = i;
                    blueY = j;
                } else if (map[i][j] == 'R') {
                    redX = i;
                    redY = j;
                } else if (map[i][j] == 'O') {
                    endX = i;
                    endY = j;
                }
            }
        }

        bfs();

        System.out.println("-1");
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(redX, redY, blueX, blueY, 1));
        v[redX][redY][blueX][blueY] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.cnt > 10) {
                return;
            }

            for (int d = 0; d < 4; d++) {
                boolean redGoal = false;
                boolean blueGoal = false;

                int rednr = cur.redr;
                int rednc = cur.redc;
                int bluenr = cur.bluer;
                int bluenc = cur.bluec;

                // 빨간색
                while (true) {
                    rednr += dr[d];
                    rednc += dc[d];

                    if (map[rednr][rednc] == '#') {
                        rednr -= dr[d];
                        rednc -= dc[d];
                        break;
                    }

                    if (rednr == endX && rednc == endY) {
                        redGoal = true;
                        break;
                    }
                }

                // 파란색
                while (true) {
                    bluenr += dr[d];
                    bluenc += dc[d];

                    if (map[bluenr][bluenc] == '#') {
                        bluenr -= dr[d];
                        bluenc -= dc[d];
                        break;
                    }

                    if (bluenr == endX && bluenc == endY) {
                        blueGoal = true;
                        break;
                    }
                }

                if (redGoal && !blueGoal) {
                    System.out.println(cur.cnt);
                    System.exit(0);
                }

                if (blueGoal) continue;

                if (rednr == bluenr && rednc == bluenc) {
                    // 상
                    if (d == 0) {
                        if (cur.redr > cur.bluer) rednr -= dr[d];
                        else bluenr -= dr[d];
                    }

                    // 우
                    else if (d == 1) {
                        if (cur.redc < cur.bluec) rednc -= dc[d];
                        else bluenc -= dc[d];
                    }

                    // 하
                    else if (d == 2) {
                        if (cur.redr < cur.bluer) rednr -= dr[d];
                        else bluenr -= dr[d];
                    }

                    // 좌
                    else if (d == 3) {
                        if (cur.redc > cur.bluec) rednc -= dc[d];
                        else bluenc -= dc[d];
                    }

                }

                if (!v[rednr][rednc][bluenr][bluenc]) {
                    v[rednr][rednc][bluenr][bluenc] = true;
                    q.add(new Node(rednr, rednc, bluenr, bluenc, cur.cnt + 1));
                }

            }
        }
    }

    private static void print(char[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}