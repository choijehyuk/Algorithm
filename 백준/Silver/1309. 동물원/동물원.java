import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[][] dp;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		
		// 사자를 한 마리도 배치하지 않는 경우도 하나의 경우의 수
		// 배치 x , 왼쪽 , 오른쪽 
		dp = new int[N][3];
		Arrays.fill(dp[0], 1);

		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
			dp[i][1] = dp[i - 1][2] + dp[i - 1][0];
			dp[i][2] = dp[i - 1][1] + dp[i - 1][0];
			for (int j = 0; j < 3; j++) {
				dp[i][j] %= 9901;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			answer += dp[N-1][i];
		}
		
		System.out.println(answer % 9901);
		
	}

}