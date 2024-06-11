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

    static int[][] map;
    static int[][] copymap;
    static int ball;
    static ArrayList<Node> list;
    static boolean flag = true;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        map = new int[7][7];
        copymap = new int[7][7];
        list = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ball = Integer.parseInt(br.readLine());

        for (int i = 0; i < 7; i++) {

            copy();
            dropBall(i);

            while (flag) {
                checkLine();
                removeBall();
                downBall();
                list.clear();
            }
            flag = true;

            int cnt = 0;
            for (int j = 0; j < 7; j++) {
                for (int k = 0; k < 7; k++) {
                    if (copymap[j][k] != 0) cnt++;
                }
            }

            answer = Math.min(cnt, answer);
        }

        System.out.println(answer);
    }

    private static void copy() {
        for (int j = 0; j < 7; j++) {
            for (int k = 0; k < 7; k++) {
                copymap[j][k] = map[j][k];
            }
        }
    }

    private static void print() {
        for (int j = 0; j < 7; j++) {
            for (int k = 0; k < 7; k++) {
                System.out.print(copymap[j][k] + " ");
            }
            System.out.println();
        }
    }

    private static void downBall() {
        for (int i = 0; i < 7; i++) {
            ArrayList<Integer> ballList = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                if (copymap[j][i] != 0) {
                    ballList.add(copymap[j][i]);
                    copymap[j][i] = 0;

                }
            }

            for (int j = 0; j < ballList.size(); j++) {
                copymap[7 - ballList.size() + j][i] = ballList.get(j);
            }
        }
    }

    private static void removeBall() {
        for (Node node : list) {
            copymap[node.r][node.c] = 0;
        }
    }

    private static void checkLine() {
        int[][] garo = new int[7][7];
        int[][] sero = new int[7][7];

        for (int i = 0; i < 7; i++) {
            int garoCnt = 0;
            for (int j = 0; j < 7; j++) {
                if (copymap[i][j] != 0) garoCnt++;

                if (copymap[i][j] == 0 && garoCnt == 0) continue;

                if (copymap[i][j] == 0 && garoCnt != 0) {
                    for (int k = 0; k < garoCnt; k++) {
                        garo[i][j - k - 1] = garoCnt;
                    }
                    garoCnt = 0;
                }
            }

            if (garoCnt != 0) {
                for (int j = 0; j < garoCnt; j++) {
                    garo[i][6 - j] = garoCnt;
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            int seroCnt = 0;
            for (int j = 0; j < 7; j++) {
                if (copymap[j][i] != 0) seroCnt++;

                if (copymap[j][i] == 0 && seroCnt == 0) continue;

                if (copymap[j][i] == 0 && seroCnt != 0) {
                    for (int k = 0; k < seroCnt; k++) {
                        garo[j - k - 1][i] = seroCnt;
                    }
                    seroCnt = 0;
                }
            }

            if (seroCnt != 0) {
                for (int j = 0; j < seroCnt; j++) {
                    sero[6 - j][i] = seroCnt;
                }
            }

        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (copymap[i][j] == 0) continue;
                if (copymap[i][j] == garo[i][j] || copymap[i][j] == sero[i][j]) list.add(new Node(i, j));
            }
        }

        if (list.size() == 0) flag = false;

    }

    private static void dropBall(int r) {
        for (int i = 6; i >= 0; i--) {
            if (copymap[i][r] == 0) {
                copymap[i][r] = ball;
                break;
            }
        }
    }
}