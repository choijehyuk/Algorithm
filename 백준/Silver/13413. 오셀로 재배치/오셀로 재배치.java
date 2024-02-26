import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            String start = br.readLine();
            String change = br.readLine();

            int black = 0;
            int white = 0;

            for (int i = 0; i < start.length(); i++) {
                if (start.charAt(i) == 'B') {
                    if (change.charAt(i) == 'W') {
                        black++;
                    }
                } else if (start.charAt(i) == 'W') {
                    if (change.charAt(i) == 'B') {
                        white++;
                    }
                }
            }

            int answer = 0;
            answer += Math.min(black, white);
            answer += Math.abs(black - white);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }
}