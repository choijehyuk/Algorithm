import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static char[] pass;
	static char[] answer;
	static boolean[] v;
	static StringBuilder sb;
	static char[] check = { 'a', 'e', 'i', 'o', 'u' };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		L = Integer.parseInt(st.nextToken()); // 암호의 길이
		C = Integer.parseInt(st.nextToken()); // 주어지는 글자
		pass = new char[C];
		answer = new char[L];
		v = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			pass[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(pass);

		comb(0, 0);
	}

	private static void comb(int idx, int k) {
		if (k == L) {
			int mo = 0;
			int ja = 0;

			for (int i = 0; i < C; i++) {
				if (v[i]) {
					if (pass[i] == 'a' || pass[i] == 'e' || pass[i] == 'i' || pass[i] == 'o' || pass[i] == 'u') {
						mo++;
					} else {
						ja++;
					}

				}
			}
			if (mo >= 1 && ja >= 2) {
				for (int i = 0; i < C; i++) {
					if(v[i]) {
						System.out.print(pass[i]);
					}
				}
				System.out.println();
			}
		}

		for (int i = idx; i < C; i++) {
			v[i] = true;
			comb(i + 1, k + 1);
			v[i] = false;
		}
	}

}
