import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] arr;
	static int cnt;
	static int lion;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int end = 0;
		for (int i = 0; i < N; i++) {

			while (end < N && lion < K) {
				if (arr[end] == 1) {
					lion++;
				}
				//System.out.println("end : " + end + " " + "cnt : " + cnt);
				end++;
			}
			if (lion == K) {
				answer = Math.min(answer, end - i);
				// System.out.println(" answer" + answer);
			}
			if (arr[i] == 1) {
				lion--;
			}

			// System.out.println();
		}
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);

	}

}