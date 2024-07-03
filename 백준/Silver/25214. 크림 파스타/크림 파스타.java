import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N + 1];
        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            min = Math.min(num[i], min);
            dp[i] = Math.max(dp[i - 1], num[i] - min);
        }
        for (int i = 1; i <= N; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);

    }
}