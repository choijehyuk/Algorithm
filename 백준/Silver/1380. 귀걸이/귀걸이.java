import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int idx = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            String[] str = new String[n + 1];
            int[] arr = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                String name = br.readLine();
                str[i] = name;
            }

            for (int i = 0; i < 2 * n - 1; i++) {
                st = new StringTokenizer(br.readLine());

                int num = Integer.parseInt(st.nextToken());
                String AB = st.nextToken();

                arr[num]++;
            }

            int ansIdx = 0;
            for (int i = 1; i <= n; i++) {
                if (arr[i] != 2) ansIdx = i;
            }

            sb.append(idx).append(" ").append(str[ansIdx]).append("\n");

            idx++;
        }
        System.out.println(sb);
    }
}