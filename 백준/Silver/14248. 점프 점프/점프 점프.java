import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] map;
	static boolean[] v;
	static int S;
	static int answer = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N];
		v = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		S = Integer.parseInt(br.readLine());

		bfs(S-1);

		System.out.println(answer);

	}

	private static void bfs(int r) {
		Queue<Integer> q = new LinkedList<>();
		q.add(r);
		v[r] = true;

		while (!q.isEmpty()) {
			Integer p = q.poll();

			int right = p + map[p];
			int left = p - map[p];

			if (right >= 0 && right < N && !v[right]) {
				v[right] = true;
				q.add(right);
				answer++;
			}
			if (left >= 0 && left < N && !v[left]) {
				v[left] = true;
				q.add(left);
				answer++;
			}

		}
	}

}