import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();

            int N = (int) Math.sqrt(s.length());

            char[][] map = new char[N][N];


            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(cnt);
                    cnt++;
                }
            }

//            printMap(map, N);

            for (int i = N - 1; i >= 0; i--) {
                for (int j = 0; j < N; j++) {
                    sb.append(map[j][i]);
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void printMap(char[][] map, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}