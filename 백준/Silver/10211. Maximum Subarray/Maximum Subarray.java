import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            int[] dp = new int[N + 1];
            int max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i] = dp[i - 1] + arr[i];
                max = Math.max(max, Math.max(arr[i], dp[i]));
            }

            for (int i = 1; i <= N; i++) {
                for (int j = N; j > i; j--) {
                    max = Math.max(max, dp[j] - dp[i]);
                }
            }
            sb.append(max + "\n");
        }
        System.out.println(sb);
    }
}