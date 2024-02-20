import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        String moves = br.readLine();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = '.';
            }
        }

        int r = 0;
        int c = 0;

        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            
            if (move == 'U') {
                int nr = r - 1;
                int nc = c;

                if (!isRange(nr, nc)) continue;
                if (map[r][c] == '-') {
                    map[r][c] = '+';
                } else if (map[r][c] == '.') {
                    map[r][c] = '|';
                }

                if (map[nr][nc] == '-') {
                    map[nr][nc] = '+';
                } else if (map[nr][nc] == '.') {
                    map[nr][nc] = '|';
                }

                r = nr;
                c = nc;
            } else if (move == 'D') {
                int nr = r + 1;
                int nc = c;

                if (!isRange(nr, nc)) continue;
                if (map[r][c] == '-') {
                    map[r][c] = '+';
                } else if (map[r][c] == '.') {
                    map[r][c] = '|';
                }

                if (map[nr][nc] == '-') {
                    map[nr][nc] = '+';
                } else if (map[nr][nc] == '.') {
                    map[nr][nc] = '|';
                }
                r = nr;
                c = nc;

            } else if (move == 'L') {
                int nr = r;
                int nc = c - 1;

                if (!isRange(nr, nc)) continue;
                if (map[r][c] == '|') {
                    map[r][c] = '+';
                } else if (map[r][c] == '.') {
                    map[r][c] = '-';
                }

                if (map[nr][nc] == '|') {
                    map[nr][nc] = '+';
                } else if (map[nr][nc] == '.') {
                    map[nr][nc] = '-';
                }
                r = nr;
                c = nc;

            } else if (move == 'R') {
                int nr = r;
                int nc = c + 1;

                if (!isRange(nr, nc)) continue;
                if (map[r][c] == '|') {
                    map[r][c] = '+';
                } else if (map[r][c] == '.') {
                    map[r][c] = '-';
                }

                if (map[nr][nc] == '|') {
                    map[nr][nc] = '+';
                } else if (map[nr][nc] == '.') {
                    map[nr][nc] = '-';
                }

                r = nr;
                c = nc;

            }
        }

        print(map);

    }

    private static void print(char[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
        return false;
    }
}