import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int kingX, kingY;
    static int stoneX, stoneY;
    static int[] dr = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};
    static int kingnr, kingnc, stonenr, stonenc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        map = new int[8][8];

        st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        kingX = 8 - (king.charAt(1) - '0');
        kingY = king.charAt(0) - 'A';

        stoneX = 8 - (stone.charAt(1) - '0');
        stoneY = stone.charAt(0) - 'A';

        kingnr = kingX;
        kingnc = kingY;
        stonenr = stoneX;
        stonenc = stoneY;

        for (int i = 0; i < N; i++) {
            String move = br.readLine();

            int d = -1;
            if (move.equals("R")) d = 0;
            else if (move.equals("L")) d = 1;
            else if (move.equals("B")) d = 2;
            else if (move.equals("T")) d = 3;
            else if (move.equals("RT")) d = 4;
            else if (move.equals("LT")) d = 5;
            else if (move.equals("RB")) d = 6;
            else if (move.equals("LB")) d = 7;

            solve(d);
        }

        char c = (char) (kingnc + 'A');
        sb.append(c).append(8 - kingnr).append("\n");
        c = (char) (stonenc + 'A');
        sb.append(c).append(8 - stonenr);

        System.out.println(sb);

    }

    private static void solve(int dir) {
        int kingnnr = kingnr + dr[dir];
        int kingnnc = kingnc + dc[dir];
        int stonennr = stonenr + dr[dir];
        int stonennc = stonenc + dc[dir];

        if (isRange(kingnnr, kingnnc)) {
            if (kingnnr == stonenr && kingnnc == stonenc) {
                if (isRange(stonennr, stonennc)) {
                    stonenr = stonennr;
                    stonenc = stonennc;
                    kingnr = kingnnr;
                    kingnc = kingnnc;
                }
            } else {
                kingnr = kingnnr;
                kingnc = kingnnc;
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8) return true;
        return false;
    }
}