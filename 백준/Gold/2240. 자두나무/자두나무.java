import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[T + 1][W + 1];

        // 초기값
        if (arr[1] == 1) {
            dp[1][0] = 1;
        } else {
            dp[1][1] = 1;
        }

        for (int i = 2; i <= T; i++) {
            for (int j = 0; j <= W; j++) {
                // 처음 안움직일 때
                if (j == 0) {
                    if (arr[i] == 1) dp[i][0] = dp[i - 1][0] + 1;
                    else dp[i][0] = dp[i - 1][0];
                } else {

                    // 홀수번 이동 == 2
                    if (j % 2 == 1) {
                        if (arr[i] == 2) dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + 1;
                        else dp[i][j] = dp[i - 1][j];
                    }

                    // 짝수번 이동 == 1
                    else {
                        if (arr[i] == 1) dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + 1;
                        else dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= W; i++) {
            answer = Math.max(answer, dp[T][i]);
        }
        System.out.println(answer);

    }
}