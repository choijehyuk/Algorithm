import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			d = new int[31][31];
			int answer = dp(N, M);
			System.out.println(answer);
		}
	}

	private static int dp(int n, int r) {
//		M COMBI N
//		13 29 
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= Math.min(i, n); j++) {
				if(j==0 || j == i) {
					d[i][j] = 1;
				}
				else {
					d[i][j] = d[i-1][j-1] + d[i-1][j];
				}
			}
		}
		return d[r][n];

	}

}