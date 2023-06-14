import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] v;
	static int answer;
	static int max = Integer.MIN_VALUE;
	static int nnr, nnc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// print(map);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j] = true;
				solve(i, j, 1, map[i][j]);
				v[i][j] = false;
			}
		}
		System.out.println(answer);

	}

	private static void solve(int r, int c, int tetris, int sum) {
		if (tetris == 4) {
			answer = Math.max(answer, sum);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc]) {
				v[nr][nc] = true;

				if (tetris == 1) {
					for (int i = 0; i < 4; i++) {
						int nnr = nr + dr[i];
						int nnc = nc + dc[i];

						if (nnr >= 0 && nnr < N && nnc >= 0 && nnc < M && !v[nnr][nnc]) {
							v[nnr][nnc] = true;
							// System.out.println("nr " + nr + " nc " + nc);
							solve(nr, nc, tetris + 2, sum + map[nnr][nnc] + map[nr][nc]);
							v[nnr][nnc] = false;
						}
					}
				}
				solve(nr, nc, tetris + 1, sum + map[nr][nc]);
				v[nr][nc] = false;

			}
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}