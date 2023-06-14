import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] zero;
	static int[] one;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringBuffer sb = new StringBuffer();
			N = Integer.parseInt(br.readLine());
			
			zero = new int[N+1];
			one = new int[N+1];
			if(N == 0) {
				System.out.println("1" + " " + "0");
				continue;
			}
			
			int answer = dpzero();
			sb.append(answer + " ");
			
			answer = dpone();
			sb.append(answer);
			
			System.out.println(sb);
			
		}
		
	}
	private static int dpone() {
		one[0] = 0;
		one[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			one[i] = one[i-1] + one[i-2];
		}
		return one[N];
	}
	private static int dpzero() {
		zero[0] = 1;
		zero[1] = 0;
		for (int i = 2; i <= N; i++) {
			zero[i] = zero[i-1] + zero[i-2];
		}
		return zero[N];
	}

}