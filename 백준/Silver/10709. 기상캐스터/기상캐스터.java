import java.io.*;
import java.util.*;

public class Main {
    static int H, W;
    static char[][] map;
    static int[][] ansMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        ansMap = new int[H][W];

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j);
                ansMap[i][j] = -1;
                if (map[i][j] == 'c') ansMap[i][j] = 0;
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (ansMap[i][j] == -1) {
                    int cnt = 1;
                    while (true) {
                        int nc = j - cnt;
                        if (nc < 0) break;
                        if (map[i][nc] == 'c') {
                            ansMap[i][j] = cnt;
                            break;
                        }
                        cnt++;
                    }

                }
            }
        }


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(ansMap[i][j] + " ");
            }
            System.out.println();
        }


    }
}