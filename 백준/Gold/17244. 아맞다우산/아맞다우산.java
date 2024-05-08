import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, cnt, time, sum;

        public Node(int r, int c, int cnt, int time, int sum) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.time = time;
            this.sum = sum;
        }
    }

    static int N, M;
    static char[][] map;
    static int[][] calMap;
    static boolean[][][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int things;
    static int startX, startY;
    static int endX, endY;
    static int check = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        calMap = new int[N][M];

        int idx = 1;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'X') things++;
                else if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }

                if (map[i][j] == '#') calMap[i][j] = -1;
                else if (map[i][j] == '.') calMap[i][j] = 0;
                else if (map[i][j] == 'X') {
                    calMap[i][j] = idx;
                    check += idx;
                    idx *= 10;
                }
            }
        }

        if (things == 0) {
            zeroBfs();
            System.exit(0);
        }
        v = new boolean[N][M][check * 3];

//        System.out.println(check + " " + things);
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(calMap[i][j] + " ");
//            }
//            System.out.println();
//        }


        // 비어있는곳 . 벽 # 경재 s 문 e 물건 x
        bfs();

    }

    private static void zeroBfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][] vv = new boolean[N][M];
        vv[startX][startY] = true;
        q.add(new Node(startX, startY, 0,0,0));

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.r == endX && cur.c == endY) {
                System.out.println(cur.time);
                System.exit(0);
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if(!isRange(nr,nc)) continue;
                if(map[nr][nc] == '#') continue;
                if(vv[nr][nc]) continue;

                q.add(new Node(nr,nc,0,cur.time + 1, 0));
                vv[nr][nc] = true;
            }
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY, 0, 0, 0));
        v[startX][startY][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            //System.out.println(cur.r + " " + cur.c + " " + cur.cnt + " " + cur.sum);

            if (map[cur.r][cur.c] == 'E') {
                if (cur.sum == check) {
                    System.out.println(cur.time);
                    return;
                }
            }

            StringBuilder s = new StringBuilder(String.valueOf(cur.sum));
            StringBuilder change = new StringBuilder("");
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '2') {
                    change.append('1');
                    continue;
                }
                change.append(s.charAt(i));
            }

            cur.sum = Integer.parseInt(String.valueOf(change));

            //System.out.println(cur.sum);

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isRange(nr, nc)) continue;
                if (map[nr][nc] == '#') continue;

                if (map[nr][nc] == 'X') {
                    if (cur.sum + calMap[nr][nc] > check * 3) continue;
                    if (v[nr][nc][cur.sum + calMap[nr][nc]]) continue;
                }

                if (map[nr][nc] == '.') {
                    if (v[nr][nc][cur.sum]) continue;
                }

                if (map[nr][nc] == 'X') {
                    q.add(new Node(nr, nc, cur.cnt + 1, cur.time + 1, cur.sum + calMap[nr][nc]));
                    v[nr][nc][cur.sum + calMap[nr][nc]] = true;
                }

                if (map[nr][nc] == '.' || map[nr][nc] == 'E' || map[nr][nc] == 'S') {
                    q.add(new Node(nr, nc, cur.cnt, cur.time + 1, cur.sum));
                    v[nr][nc][cur.sum] = true;
                }

            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
        return false;
    }
}