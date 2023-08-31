import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();
            int dir = 0;
            int answer = 0;
            int minX = 0;
            int maxX = 0;
            int minY = 0;
            int maxY = 0;
            int x = 0;
            int y = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == 'F') {
                    if (dir == 0) {
                        x++;
                    } else if (dir == 1) {
                        y++;
                    } else if (dir == 2) {
                        x--;
                    } else if (dir == 3) {
                        y--;
                    }
                } else if (c == 'B') {
                    if (dir == 0) {
                        x--;
                    } else if (dir == 1) {
                        y--;
                    } else if (dir == 2) {
                        x++;
                    } else if (dir == 3) {
                        y++;
                    }
                } else if (c == 'L') {
                    dir = (dir + 3) % 4;
                } else if (c == 'R') {
                    dir = (dir + 1) % 4;
                }

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }


            answer = (Math.abs(minX) + Math.abs(maxX)) * (Math.abs(minY) + Math.abs(maxY));
            System.out.println(answer);
        }
    }
}
