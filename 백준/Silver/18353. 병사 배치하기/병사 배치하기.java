import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] army = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < army.length; i++) {
            army[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1);

        int answer = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (army[j] > army[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(N - answer);
    }
}