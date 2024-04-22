import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[117];
        dp[1] = dp[2] = dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-3];
        }
        System.out.print(dp[n]);


    }
}