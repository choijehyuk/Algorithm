import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static long[] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T= Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			d = new long[N+1];
			if(N <=3) {
				System.out.println("1");
				continue;
			}
			long answer = dp();
			System.out.println(answer);
		}
	}
	private static long dp() {
		d[1] = 1;
		d[2] = 1;
		d[3] = 1;
		
		for (int i = 4; i <= N; i++) {
			d[i] = d[i-2] + d[i-3];
		}
		
		return d[N];
	}

}