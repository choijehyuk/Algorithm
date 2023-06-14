import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n+1];
		if(n < 3) {
			if(n == 0) {
				System.out.println("0");
			}
			else {
				System.out.println("1");
			}
			System.exit(0);
		}
		long answer = fibo(n,dp);
		System.out.println(answer);
	}

	private static long fibo(int n, long[] dp) {
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}

	

	

}