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

        long[] len = new long[N + 1];
        len[1] = 1;

        for (int i = 2; i <= N; i++) {
            len[i] = len[i - 1] + len[i - 2];
        }

        long[] dp = new long[N + 1];
        dp[1] = 4;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + len[i] * 2;
        }

        System.out.println(dp[N]);


    }
}