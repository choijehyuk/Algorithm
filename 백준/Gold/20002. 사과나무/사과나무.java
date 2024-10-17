import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        int max = Integer.MIN_VALUE;

        for (int k = 1; k <= N; k++) {
            for (int i = k; i <= N; i++) {
                for (int j = k; j <= N; j++) {
                    max = Math.max(max, dp[i][j] - dp[i - k][j] - dp[i][j - k] + dp[i - k][j - k]);
                }
            }
        }

        System.out.println(max);
    }
}