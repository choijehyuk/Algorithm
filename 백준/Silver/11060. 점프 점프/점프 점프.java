import java.util.*;
import java.io.*;
 
public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
 
        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
 
        dp[1] = 0;
        for (int i = 1; i <= N; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
 
                int jump = arr[i];
                for (int j = 1; j <= jump; j++) {
                    if (i + j > N)
                        continue;
 
                    dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                }
            }
        }
 
        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
    }
}