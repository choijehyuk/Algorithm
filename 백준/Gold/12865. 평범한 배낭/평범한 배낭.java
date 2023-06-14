import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,K,W,V;
	static int[] weights;
	static int[] profits;
	static int[][] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 물품의 수 
		K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게 // 각 물건의 무게 w 가치 v 
		weights = new int[N+1];
		profits = new int[N+1];
		d = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			weights[i] = W;
			profits[i] = V;
			
		}
				
		int answer = dp();
		System.out.println(answer);
	}
	private static int dp() {		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if(weights[i] > j) {
					d[i][j] = d[i-1][j];
				}
				else {
					d[i][j] = Math.max(d[i-1][j], profits[i] + d[i-1][j-weights[i]]);
				}
			}
		}
		return d[N][K];
	}

}