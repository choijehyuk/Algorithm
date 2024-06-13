import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int s, d, z;
        boolean isMove;

        public Shark(int s, int d, int z, boolean isMove) {
            this.s = s;
            this.d = d;
            this.z = z;
            this.isMove = isMove;
        }
    }

    static class SharList {
        int r, c, s, d, z;

        public SharList(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int R, C, M;
    static Shark[][] sharks;
    static ArrayList<SharList> list;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sharks = new Shark[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sharks[i][j] = new Shark(0, 0, 0, false);
            }
        }
        list = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sharks[i][j].s = 0;
                sharks[i][j].d = 0;
                sharks[i][j].z = 0;
                sharks[i][j].isMove = false;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            // 행 열 속력 이동방향 크기
            // r c  s    d     z
            // 위 아래 오른쪽 왼쪽 1, 2, 3, 4
            sharks[r][c] = new Shark(s, d, z, false);
            //list.add(new SharList(r, c, s, d, z));
        }

        int idx = 0;

        while (idx < C) {

            eatShark(idx);
            addList();
            moveShark();
            moveFalse();
            list.clear();
            idx++;
        }

        System.out.println(answer);

    }

    private static void addList() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (sharks[i][j].z != 0) {
                    list.add(new SharList(i, j, sharks[i][j].s, sharks[i][j].d, sharks[i][j].z));
                }
            }
        }
    }

    private static void moveFalse() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sharks[i][j].isMove = false;
            }
        }
    }

    private static void moveShark() {
        for (SharList shark : list) {
            int d = shark.d;

            // 위
            if (d == 0) {
                int dir = -1;
                int nr = shark.r;
                int nc = shark.c;
                if (!sharks[shark.r][shark.c].isMove) {
                    sharks[shark.r][shark.c] = new Shark(0, 0, 0, false);
                }

                for (int i = 0; i < shark.s; i++) {
                    nr += dir;
                    // 범위 밖
                    if (!isRangeNr(nr)) {
                        dir *= -1;
                        nr += dir * 2;
                    }
                }
                if (dir == 1) shark.d = 1;

                // 움직여서 가는곳에 아직 안움직였으면
                if (!sharks[nr][nc].isMove) {
                    sharks[nr][nc].s = shark.s;
                    sharks[nr][nc].d = shark.d;
                    sharks[nr][nc].z = shark.z;
                    sharks[nr][nc].isMove = true;
                }
                // 움직여서 가는곳에 움직인게 있으면 크기비교
                else {
                    if (sharks[nr][nc].z < shark.z) {
                        sharks[nr][nc].s = shark.s;
                        sharks[nr][nc].d = shark.d;
                        sharks[nr][nc].z = shark.z;
                    }
                }
            }
            // 아래
            else if (d == 1) {
                int dir = 1;
                int nr = shark.r;
                int nc = shark.c;
                if (!sharks[shark.r][shark.c].isMove) {
                    sharks[shark.r][shark.c] = new Shark(0, 0, 0, false);
                }

                for (int i = 0; i < shark.s; i++) {
                    nr += dir;
                    // 범위 밖
                    if (!isRangeNr(nr)) {
                        dir *= -1;
                        nr += dir * 2;
                    }
                }
                if (dir == -1) shark.d = 0;


                // 움직여서 가는곳에 아직 안움직였으면
                if (!sharks[nr][nc].isMove) {
                    sharks[nr][nc].s = shark.s;
                    sharks[nr][nc].d = shark.d;
                    sharks[nr][nc].z = shark.z;
                    sharks[nr][nc].isMove = true;
                }
                // 움직여서 가는곳에 움직인게 있으면 크기비교
                else {
                    if (sharks[nr][nc].z < shark.z) {
                        sharks[nr][nc].s = shark.s;
                        sharks[nr][nc].d = shark.d;
                        sharks[nr][nc].z = shark.z;
                    }
                }
            }
            // 오른쪽
            else if (d == 2) {
                int dir = 1;
                int nr = shark.r;
                int nc = shark.c;
                if (!sharks[shark.r][shark.c].isMove) {
                    sharks[shark.r][shark.c] = new Shark(0, 0, 0, false);
                }

                for (int i = 0; i < shark.s; i++) {
                    nc += dir;
                    // 범위 밖
                    if (!isRangeNc(nc)) {
                        dir *= -1;
                        nc += dir * 2;
                    }
                }
                if (dir == -1) shark.d = 3;

                // 움직여서 가는곳에 아직 안움직였으면
                if (!sharks[nr][nc].isMove) {
                    sharks[nr][nc].s = shark.s;
                    sharks[nr][nc].d = shark.d;
                    sharks[nr][nc].z = shark.z;
                    sharks[nr][nc].isMove = true;
                }
                // 움직여서 가는곳에 움직인게 있으면 크기비교
                else {
                    if (sharks[nr][nc].z < shark.z) {
                        sharks[nr][nc].s = shark.s;
                        sharks[nr][nc].d = shark.d;
                        sharks[nr][nc].z = shark.z;
                    }
                }
            }
            // 왼쪽
            else if (d == 3) {
                int dir = -1;
                int nr = shark.r;
                int nc = shark.c;
                if (!sharks[shark.r][shark.c].isMove) {
                    sharks[shark.r][shark.c] = new Shark(0, 0, 0, false);
                }

                for (int i = 0; i < shark.s; i++) {
                    nc += dir;
                    // 범위 밖
                    if (!isRangeNc(nc)) {
                        dir *= -1;
                        nc += dir * 2;
                    }
                }
                if (dir == 1) shark.d = 2;

                // 움직여서 가는곳에 아직 안움직였으면
                if (!sharks[nr][nc].isMove) {
                    sharks[nr][nc].s = shark.s;
                    sharks[nr][nc].d = shark.d;
                    sharks[nr][nc].z = shark.z;
                    sharks[nr][nc].isMove = true;
                }
                // 움직여서 가는곳에 움직인게 있으면 크기비교
                else {
                    if (sharks[nr][nc].z < shark.z) {
                        sharks[nr][nc].s = shark.s;
                        sharks[nr][nc].d = shark.d;
                        sharks[nr][nc].z = shark.z;
                    }
                }
            }
        }
    }

    private static boolean isRangeNc(int nc) {
        if (nc >= 0 && nc < C) return true;
        return false;
    }

    private static boolean isRangeNr(int nr) {
        if (nr >= 0 && nr < R) return true;
        return false;
    }

    private static void eatShark(int c) {
        for (int i = 0; i < R; i++) {
            if (sharks[i][c].z != 0) {
                answer += sharks[i][c].z;
//                System.out.println(i + " " + c + " " + sharks[i][c].s + " " + sharks[i][c].d + " " + sharks[i][c].z);
//                System.out.println(list.get(0).r + " " + list.get(0).c + " " + list.get(0).s + " " + );
                list.remove(new SharList(i, c, sharks[i][c].s, sharks[i][c].d, sharks[i][c].z));

                sharks[i][c].s = 0;
                sharks[i][c].d = 0;
                sharks[i][c].z = 0;
                break;
            }
        }
    }
}