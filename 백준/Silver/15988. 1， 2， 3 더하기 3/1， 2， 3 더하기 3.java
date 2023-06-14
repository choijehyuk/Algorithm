import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int T;
	static int N;
	static long[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		T = Integer.parseInt(br.readLine());
		
		dp = new long[1000001];
		long div = 1000000009;

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		dp[4] = 7;

		for (int j = 5; j <= 1000000; j++) {
			 dp[j] = ((dp[j-1] * 2) % div - dp[j-4] + div) % div;
		}
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			
			if(N <= 4) {
				if(N == 1) {
					sb.append(1 + "\n");
					continue;
					
				}
				else if (N ==2) {
					sb.append(2 + "\n");
					continue;
					
				}
				else if(N ==3) {
					sb.append(4 + "\n");
					continue;
					
				}
				else if(N ==4) {
					sb.append(7 + "\n");
					continue;
				}
				
			}
			
			long answer = dp[N] % div;
			
			sb.append(answer + "\n");			
		}
		System.out.println(sb);
		
	}

}