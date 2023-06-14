import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] arr;
	static int[][] d;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];
		d = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - 1]) + arr[i][j];
			}
		}

		for (int i = 1; i <= N; i++) {
			answer = Math.max(answer, d[N][i]);
		}

		System.out.println(answer);
	}
}