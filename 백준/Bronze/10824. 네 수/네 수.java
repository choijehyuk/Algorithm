import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String A = st.nextToken();
		String B = st.nextToken();
		String AB = A + B;

		String C = st.nextToken();
		String D = st.nextToken();
		String CD = C + D;
		long answer = Long.parseLong(AB) + Long.parseLong(CD);

		System.out.println(answer);
	}
}