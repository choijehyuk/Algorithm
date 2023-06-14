import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	static int N;
	static int[][] cost;
	static int[] r;
	static int[] g;
	static int[] b;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N+1][3];
		r = new int[N+1];
		g = new int[N+1];
		b = new int[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r[i] = Integer.parseInt(st.nextToken());
			g[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = dp();
		System.out.println(answer);
		
		
	}
	private static int dp() {
		cost[1][0] = r[1];
		cost[1][1] = g[1];
		cost[1][2] = b[1];
		
		for (int i = 2; i <= N; i++) {
			cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + r[i];
			cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + g[i];
			cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + b[i];
		}
		min = Math.min(cost[N][0], cost[N][1]);
		min = Math.min(min, cost[N][2]);
		
		return min;
	}

}