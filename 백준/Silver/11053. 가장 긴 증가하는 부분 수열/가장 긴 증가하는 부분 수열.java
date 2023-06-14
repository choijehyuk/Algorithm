import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] A;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		A = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int answer = dp();
		//System.out.println(Arrays.toString(A));
		//System.out.println(Arrays.toString(dp));
		System.out.println(answer);

	}

	private static int dp() {
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j] && dp[i] < dp[j]+1) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		 Arrays.sort(dp);
		return dp[N - 1];
	}

}