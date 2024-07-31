import java.io.*;
import java.util.*;

class Main {
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        map = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int call = Integer.parseInt(st.nextToken());

                remove(call);

                int answer = check();

                if (answer >= 3) {
                    System.out.println(i * 5 + j + 1);
                    System.exit(0);
                }
            }
        }
    }

    private static int check() {
        int cnt = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < 5; i++) {
            int garo = 0;
            int sero = 0;
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 0) garo++;
                if (map[j][i] == 0) sero++;
                if (i == j && map[i][j] == 0) left++;
                if (i + j == 4 && map[i][j] == 0) right++;
            }
            if (garo == 5) cnt++;
            if (sero == 5) cnt++;
            if (left == 5) cnt++;
            if (right == 5) cnt++;
        }

        return cnt;
    }


    private static void remove(int call) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == call) map[i][j] = 0;
            }
        }
    }
}