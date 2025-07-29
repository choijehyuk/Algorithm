import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[][] map = new int[R][C];

        int num = 1;
        int x = R;
        int y = 0;
        int width = C - 1;
        int height = R;

        while (num <= R * C) {
            for (int i = 0; i < height && num <= R * C; i++) {
                map[--x][y] = num++;
            }
            height--;

            for (int i = 0; i < width && num <= R * C; i++) {
                map[x][++y] = num++;
            }
            width--;

            for (int i = 0; i < height && num <= R * C; i++) {
                map[++x][y] = num++;
            }
            height--;

            for (int i = 0; i < width && num <= R * C; i++) {
                map[x][--y] = num++;
            }
            width--;
        }

//        print(map, R , C);
        while (true) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == K) {
                        System.out.println((j + 1) + " " + (R - i));
                        System.exit(0);
                    }
                }
            }
            System.out.println(0);
            System.exit(0);
        }
    }

    private static void print(int[][] map, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


}
