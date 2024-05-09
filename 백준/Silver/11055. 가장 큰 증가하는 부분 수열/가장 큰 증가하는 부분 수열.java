import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];

        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = A[i];
            for (int j = 1; j < i; j++) {
                if (A[i] > A[j]) dp[i] = Math.max(dp[j] + A[i], dp[i]);
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);


    }
}