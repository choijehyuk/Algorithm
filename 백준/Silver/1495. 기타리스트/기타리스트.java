import java.util.*;
import java.io.*;

public class Main {
    static int N, S, M;
    static int[] V;
    static boolean[][] dp;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        V = new int[N + 1];
        dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) {
                    int plus = j + V[i];
                    int minus = j - V[i];

                    if (plus <= M) dp[i][plus] = true;
                    if (minus >= 0) dp[i][minus] = true;
                }
            }
        }

        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);


    }
}