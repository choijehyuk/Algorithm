import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);

        boolean[] page = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            page[x] = true;
        }

        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            if (page[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            for (int j = 1; j <= i; j++) {
                if (page[j])
                    continue;
                dp[i] = Math.min(dp[i], dp[j - 1] + 5 + (i - j + 1) * 2);
            }
        }

        System.out.println(dp[N]);
    }
}