import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] input = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[41];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int answer = 1;

        for (int i = 1; i <= M; i++) {
            int cnt = input[i] - input[i - 1] - 1;
            answer *= dp[cnt];
        }
        answer *= dp[N - input[M]];

        System.out.println(answer);

    }
}