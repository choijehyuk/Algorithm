import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) list.add(new Pair(i, j));
            }
        }

        solve(0);
    }

    private static void solve(int idx) {
        if (idx == list.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb.toString());
            System.exit(0);
        }

        int x = list.get(idx).x;
        int y = list.get(idx).y;

        for (int i = 1; i <= 9; i++) {
            if (canFill(x, y, i)) {
                board[x][y] = i;
                solve(idx + 1);
                board[x][y] = 0;
            }
        }
    }

    private static boolean canFill(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == num || board[i][y] == num) return false;
        }

        for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}