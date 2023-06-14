import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int first, second;
	static int[][] arr;
	static boolean[] v;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		first = Integer.parseInt(st.nextToken());
		second = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		v = new boolean[N + 1];

		dfs(first, 0);
		
		System.out.println("-1");
	}

	private static void dfs(int start, int cnt) {
		if (start == second) {
			answer = cnt;
			System.out.println(answer);
			System.exit(0);
		}
		
		v[first] = true;
		for (int i = 1; i <= N; i++) {
			if (!v[i] && arr[start][i] == 1) {
				//System.out.println(start + " " + i);
				v[i] = true;
				dfs(i, cnt + 1);
				v[i] = false;
			}
		}
	}

}