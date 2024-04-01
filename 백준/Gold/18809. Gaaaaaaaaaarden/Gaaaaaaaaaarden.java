import java.io.*;
import java.util.*;

public class Main {
    static class Cur {
        int r, c;

        public Cur(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Node {
        String color;
        int time;

        public Node(String color, int time) {
            this.color = color;
            this.time = time;
        }
    }

    static int N, M, G, R;
    static int[][] map;
    static Node[][] flowerMap;
    static ArrayList<Cur> possibleGround;
    static int[] green;
    static int[] red;
    static boolean[] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        possibleGround = new ArrayList<>();
        green = new int[G];
        red = new int[R];
        v = new boolean[10];

        // 0 호수 , 1 배양액 못부리는 땅 , 2 배양액 뿌릴 수 있는 땅
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    possibleGround.add(new Cur(i, j));
                }
            }
        }

        //print(map);
        // 조합 초록색 뽑고 빨간색 뽑고
        selectGreenGround(0, 0);
        System.out.println(answer);

    }

    private static void selectGreenGround(int idx, int depth) {
        if (depth == G) {
            selectRedGround(0, 0);
            return;
        }

        for (int i = idx; i < possibleGround.size(); i++) {
            if (!v[i]) {
                v[i] = true;
                green[depth] = i;
                selectGreenGround(i + 1, depth + 1);
                v[i] = false;
            }
        }
    }

    private static void selectRedGround(int idx, int depth) {
        if (depth == R) {
            flower();
            return;
        }

        for (int i = idx; i < possibleGround.size(); i++) {
            if (!v[i]) {
                v[i] = true;
                red[depth] = i;
                selectRedGround(i + 1, depth + 1);
                v[i] = false;
            }
        }
    }

    private static void flower() {
        Queue<Cur> q = new LinkedList<>();
        flowerMap = new Node[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                flowerMap[i][j] = new Node("NONE", 0);
            }
        }

        for (int i = 0; i < green.length; i++) {
            Cur cur = possibleGround.get(green[i]);
            flowerMap[cur.r][cur.c] = new Node("GREEN", 0);
            q.add(new Cur(cur.r, cur.c));
        }

        for (int i = 0; i < red.length; i++) {
            Cur cur = possibleGround.get(red[i]);
            flowerMap[cur.r][cur.c] = new Node("RED", 0);
            q.add(new Cur(cur.r, cur.c));
        }

        int flowerCnt = 0;
        while (!q.isEmpty()) {
            Cur cur = q.poll();

            String curColor = flowerMap[cur.r][cur.c].color;
            int curTime = flowerMap[cur.r][cur.c].time;

            if (flowerMap[cur.r][cur.c].color.equals("FLOWER")) continue;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isRange(nr, nc)) continue;
                if (map[nr][nc] == 0) continue;

                if (flowerMap[nr][nc].color.equals("NONE")) {
                    flowerMap[nr][nc] = new Node(curColor, curTime + 1);
                    q.add(new Cur(nr,nc));
                } else if (flowerMap[nr][nc].color.equals("RED")) {
                    if (curColor.equals("GREEN") && flowerMap[nr][nc].time == curTime + 1) {
                        flowerCnt++;
                        flowerMap[nr][nc].color = "FLOWER";
                    }
                } else if (flowerMap[nr][nc].color.equals("GREEN")) {
                    if (curColor.equals("RED") && flowerMap[nr][nc].time == curTime + 1) {
                        flowerCnt++;
                        flowerMap[nr][nc].color = "FLOWER";
                    }
                }

            }
        }
        answer = Math.max(answer, flowerCnt);
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