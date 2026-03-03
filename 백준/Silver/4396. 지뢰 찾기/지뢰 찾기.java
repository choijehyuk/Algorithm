import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m;
    static char[][] map;
    static char[][] game;
    static int[][] ansMap;
    static StringBuilder sb;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        game = new char[n][n];
        ansMap = new int[n][n];


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                game[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game[i][j] == 'x') {
                    int boom = 0;
                    for (int d = 0; d < 8; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (!isRange(nr, nc)) continue;

                        if (map[nr][nc] == '*') boom++;
                    }

                    ansMap[i][j] = (char) (boom);
                }
            }
        }

        print();

        if(sb.length() == 0) {
            printBomb();
            System.out.println(sb);
        }
        else {
            System.out.println(sb);
        }

    }

    private static void printBomb() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == '*') sb.append("*");
                else if(game[i][j] == 'x') sb.append(ansMap[i][j]);
                else sb.append(".");
            }
            sb.append("\n");
        }
    }

    private static void print() {
        L : for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game[i][j] == 'x' && map[i][j] == '*') {
                    sb.setLength(0);
                    break L;
                }
                else if (game[i][j] == 'x') sb.append(ansMap[i][j]);
                else sb.append(".");
            }
            sb.append("\n");
        }
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < n;
    }
}