import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static char[][] map;
	static int answer;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new char[5][5];
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		// print(map);

		comb(0, 0, 0, new int[7]);
		System.out.println(answer);
	}

	private static void comb(int idx, int k, int dasom, int[] sel) {
		if (k - dasom > 3)
			return;

		if (k == sel.length) {
			//System.out.println(Arrays.toString(sel));
			boolean[] v = new boolean[7];
			v[0] = true;

			dfs(sel[0] / 5, sel[0] % 5, v, sel);
			return;
		}

		if (idx >= 25) {
			return;
		}

		sel[k] = idx;
		comb(idx + 1, k + 1, map[idx / 5][idx % 5] == 'S' ? dasom + 1 : dasom, sel);
		comb(idx + 1, k, dasom, sel);

	}

	private static void dfs(int r, int c, boolean[] v, int[] sel) {
		boolean flag = false;
		for (int i = 0; i < v.length; i++) {
			if (!v[i]) {
				flag = true;
				break;
			}
		}

		// 아이들이 모두 4방에 앉아 있다면
		if (!flag)
			answer++;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
				int nValue = 5 * nr + nc;
				for (int k = 0; k < 7; k++) {

					if (!v[k] && sel[k] == nValue) {
						v[k] = true;
						dfs(nr, nc, v, sel);
					}
				}
			}
		}
	}

	private static void print(char[][] map) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}