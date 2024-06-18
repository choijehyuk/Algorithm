import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, dir;

        public Node(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    static int N, K;
    static int[][] map;
    static Node[] horse;
    static ArrayList<Integer> list[][];
    static ArrayList<Integer> del;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        horse = new Node[K];

        list = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                list[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;

            list[r][c].add(i);
            horse[i] = new Node(r, c, dir);
        }


        while (answer++ <= 1000) {
            move();
        }

        System.out.println(-1);


    }

    private static void move() {
        for (int i = 0; i < K; i++) {
            Node cur = horse[i];

            int nr = cur.r + dr[cur.dir];
            int nc = cur.c + dc[cur.dir];

            if (!isRange(nr, nc) || map[nr][nc] == 2) {
                horse[i].dir = changeDir(cur.dir);

                int nnr = horse[i].r + dr[horse[i].dir];
                int nnc = horse[i].c + dc[horse[i].dir];

                if (isRange(nnr, nnc)) {
                    if (map[nnr][nnc] == 0) {
                        remove(cur.r, cur.c, nnr, nnc, i, false);
                    } else if (map[nnr][nnc] == 1) {
                        remove(cur.r, cur.c, nnr, nnc, i, true);
                    }
                }
            } else {
                if (map[nr][nc] == 0) remove(cur.r, cur.c, nr, nc, i, false);
                else if (map[nr][nc] == 1) remove(cur.r, cur.c, nr, nc, i, true);
            }
            if (isEnd()) {
                System.out.println(answer);
                System.exit(0);
            }
        }
    }

    private static boolean isEnd() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (list[i][j].size() >= 4) return true;
            }
        }
        return false;
    }

    private static void remove(int r, int c, int nnr, int nnc, int num, boolean rev) {
        int size = list[r][c].size();
        boolean flag = true;
        del = new ArrayList<>();
        int idx = 0;

        for (int i = 0; i < size; i++) {
            if (list[r][c].get(i) == num) {
                idx = i;
                flag = false;
            }
            if (!flag) del.add(list[r][c].get(i));
        }

        if (rev) Collections.reverse(del);

        for (int i = idx; i < size; i++) {
            list[r][c].remove(idx);
        }

        for (int i = 0; i < del.size(); i++) {
            horse[del.get(i)].r = nnr;
            horse[del.get(i)].c = nnc;
            list[nnr][nnc].add(del.get(i));
        }
    }


    private static int changeDir(int dir) {
        if (dir == 0) return 1;
        else if (dir == 1) return 0;
        else if (dir == 2) return 3;
        else if (dir == 3) return 2;
        return -1;
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
        return false;
    }
}