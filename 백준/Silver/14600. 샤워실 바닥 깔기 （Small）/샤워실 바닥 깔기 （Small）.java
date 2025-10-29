import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, K);
        int[][] map = new int[size][size];

        map[size - y][x - 1] = -1;

        if (K == 1) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[i][j] = 1;
                }
            }
            map[size - y][x - 1] = -1;
        } else {
            int idx = 1;
            int area = 0;
            for (int i = 0; i < size; i += 2) {
                for (int j = 0; j < size; j += 2) {
                    if (map[i][j] == -1 || map[i + 1][j] == -1 || map[i][j + 1] == -1 || map[i + 1][j + 1] == -1) {
                        map[i][j] = idx;
                        map[i + 1][j + 1] = idx;
                        map[i][j + 1] = idx;
                        map[i + 1][j] = idx;
                        idx++;
                        map[size - y][x - 1] = -1;
                        if (i == 0 && j == 0) area = 1;
                        else if (i == 0 && j == 2) area = 2;
                        else if (i == 2 && j == 0) area = 3;
                        else if (i == 2 && j == 2) area = 4;
                    } else {
                        map[i][j] = idx;
                        map[i + 1][j + 1] = idx;
                        map[i][j + 1] = idx;
                        map[i + 1][j] = idx;
                        idx++;
                    }
                }
            }
            map[1][1] = idx;
            map[1][2] = idx;
            map[2][1] = idx;
            map[2][2] = idx;
            if (area == 1) map[1][1] = area;
            else if (area == 2) map[1][2] = area;
            else if (area == 3) map[2][1] = area;
            else if (area == 4) map[2][2] = area;
            map[size - y][x - 1] = -1;
        }

        // 3  , 8

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < size; i += 4) {
            for (int j = 0; j < size; j += 4) {

            }
        }


    }
}