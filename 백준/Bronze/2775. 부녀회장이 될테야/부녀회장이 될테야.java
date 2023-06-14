import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int k,n;
	static int[][] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			d = new int[k+1][15];
			int answer = dp();
			System.out.println(answer);
		}
	}
	private static int dp() {
		for (int i = 1; i < 15; i++) {
			d[0][i] = i;
		}
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= j; k++) {
					d[i][j] += d[i-1][k]; 					
				}
			}
		}
		
		 return d[k][n];
	}

}