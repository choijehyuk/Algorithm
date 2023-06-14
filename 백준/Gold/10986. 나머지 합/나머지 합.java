import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static long[] arr;
	static int sum;
	static long answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[M];

		/*
		 * 부분합 알고리즘 - 1~10까지 더한거에서 1~7까지 더한거 빼면 8~10까지 더한거 이 원리로 풀기
		 * 
		 */
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sum += Integer.parseInt(st.nextToken()) % M;
			arr[sum % M]++;
		}

		for (int i = 0; i < M; i++) {
			answer += (arr[i] * (arr[i] - 1)) / 2;
		}
		answer += arr[0];
		System.out.println(answer);
	}

}
