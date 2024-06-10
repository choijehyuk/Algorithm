import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int num = Integer.parseInt(br.readLine());

            int two = 0, five = 0;

            for (int j = 2; j <= num; j *= 2) {
                two += num / j;
            }
            for (int j = 5; j <= num; j *= 5) {
                five += num / j;
            }

            sb.append(Math.min(two, five)).append("\n");
        }
        System.out.println(sb);
    }
}