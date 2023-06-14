import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		dfs(0, 0);
		System.out.println(sb);
	}

	private static void dfs(int num, int digits) {
		if (N == digits) {
			if (isPrime(num)) {
				sb.append(num + "\n");
			}
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (isPrime(num * 10 + i)) {
				dfs(num * 10 + i, digits + 1);
			}
		}

	}

	private static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}