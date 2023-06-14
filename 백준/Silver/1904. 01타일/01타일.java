import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		long[] num = new long[n + 1];

		num[0] = 1;
		num[1] = 1;

		for (int i = 2; i <= n; i++) {
			num[i] = (num[i - 2] + num[i - 1]) % 15746;
		}

		System.out.println(num[n]);
	}

}