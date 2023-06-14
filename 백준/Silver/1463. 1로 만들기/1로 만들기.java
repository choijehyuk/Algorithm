import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];

		int answer = dp(N);
		System.out.println(answer);
	}

	private static int dp(int n) {
		arr[0] = 0;
		arr[1] = 0;
		
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i-1] + 1;
			if(i % 2 == 0) {
				arr[i] = Math.min(arr[i], arr[i/2]+1);
			}
			if(i % 3 == 0) {
				arr[i] = Math.min(arr[i], arr[i/3]+1);
			}
		}
		return arr[n];
	}

}
