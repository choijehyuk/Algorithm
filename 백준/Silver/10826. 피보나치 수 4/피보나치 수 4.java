import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[N + 2];

        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        System.out.println(dp[N]);
    }
}