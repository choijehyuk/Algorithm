import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int B, S, G, P, D;
	static char[] mvp;
	static int max;
	static int odd, even;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken()) - 1;
		S = Integer.parseInt(st.nextToken()) - 1;
		G = Integer.parseInt(st.nextToken()) - 1;
		P = Integer.parseInt(st.nextToken()) - 1;
		D = P + 1;

		mvp = new char[N + 1];
		String s = br.readLine();
		for (int i = 0; i < N; i++) {
			mvp[i + 1] = s.charAt(i);
		}
		dp = new int[N+1];
		max = 0;

		int before = 0;
		for (int i = 1; i <= N; i++) {
			if (mvp[i] == 'D') {
				max+= D;
				continue;
			}
			int value = add(mvp[i]);
			max += value - before;
			before = value - before;
		}
	
		System.out.println(max);
	}

	private static int add(char c) {
		if (c == 'B') {
			return B;
		} else if (c == 'S') {
			return S;
		} else if (c == 'G') {
			return G;
		} else if (c == 'P') {
			return P;
		} else if (c == 'D') {
			return D;
		}
		return 0;
	}

}