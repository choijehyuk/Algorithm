import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][M];

        for (int i = 0; i < M; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = i; j < M; j++) {
                int sum = 0;
                for (int k = 0; k <= j - 1; k++) {
                    sum += dp[i - 1][k];
                }
                dp[i][j] = sum;
            }
        }
        System.out.println(dp[N - 1][M - 1]);

    }

}