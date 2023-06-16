import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long A, B, C;
	static long answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		answer = cal(A, B, C);
		System.out.println(answer);
	}

	private static long cal(long a, long b, long c) {
		if (b == 1)
			return a % c;

		long div = cal(a, b / 2, c);
		div = div * div % c;
		
		if (b % 2 == 0)
			return div;
		else
			return div * a % c;
	}

}