import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println("1");
			System.exit(0);
		}
		arr = new int[N + 1];

		int answer = dp();
		System.out.println(answer % 10007);

	}

	private static int dp() {
		arr[1] = 1;
		arr[2] = 3;

		for (int i = 3; i <= N; i++) {
			arr[i] = arr[i - 1] % 10007 + arr[i - 2] * 2 % 10007;
		}

		return arr[N];
	}

}
