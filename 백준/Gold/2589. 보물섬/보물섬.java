import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int L, W;
	static char[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int max = Integer.MIN_VALUE;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[L][W];

		for (int i = 0; i < L; i++) {
			String s = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		// print(map);

		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'L') {
					v = new boolean[L][W];
					solve(i, j);
					answer = Math.max(answer, max);
				}
			}
		}
		System.out.println(answer);

	}

	private static void solve(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c, 0));
		v[r][c] = true;
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr >= 0 && nr < L && nc >= 0 && nc < W && !v[nr][nc] && map[nr][nc] == 'L') {
					v[nr][nc] = true;
					q.add(new Point(nr, nc, p.cnt + 1));
					max = Math.max(max, p.cnt + 1);
				}
			}
		}

	}

	private static void print(char[][] map) {
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
