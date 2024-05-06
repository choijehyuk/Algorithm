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
            st = new StringTokenizer(br.readLine());

            int day = 1;
            long sum = 0;

            for (int i = 0; i < 6; i++) {
                sum += Integer.parseInt(st.nextToken());
            }

            while (sum <= N) {
                sum *= 4;
                ++day;
            }

            sb.append(day).append("\n");
        }

        System.out.print(sb);

    }
}