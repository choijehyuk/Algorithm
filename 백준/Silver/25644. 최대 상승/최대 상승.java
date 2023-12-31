import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();


        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = num;
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], num - dp[i - 1][1]);
            dp[i][1] = Math.min(dp[i - 1][1], num);
        }

        System.out.println(dp[N - 1][0]);
    }
}