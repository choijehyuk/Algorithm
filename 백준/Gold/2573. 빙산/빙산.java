import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M;
	static int[][] map;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int[][] meltmap;
	static boolean[][] v;
	static int dung;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		meltmap = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				meltmap[i][j] = map[i][j];
			}
		}

		// print(map);
		solve();
		System.out.println("0");
	}

	private static void solve() {
		dung = 0;
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					melt(i, j); // 얼음 녹이기
				}
			}
		}
		// 녹여주고 다시 map에 넣기
		copy();
		// print(map);
		// 덩어리 개수 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !v[i][j]) {
					check(i, j);
					dung++;
					// System.out.println(i + " " + j);
				}
			}
		}
		// System.out.println(dung);
		answer++;
		if (dung >= 2) {
			System.out.println(answer);
			System.exit(0);
		}
		int end = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					end++;
				}
			}
		}
		if(end != N*M) {
			solve();
			
		}
	}

	private static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = meltmap[i][j];
//				if(map[i][j] < 0) map[i][j] = 0;
			}
		}
	}

	private static void check(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		v[r][c] = true;
		q.add(new Point(r, c));
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0 && !v[nr][nc]) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc));

				}
			}
		}
	}

	private static void melt(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (map[nr][nc] == 0) {
				if (meltmap[r][c] > 0) {
					meltmap[r][c]--;
				}
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
