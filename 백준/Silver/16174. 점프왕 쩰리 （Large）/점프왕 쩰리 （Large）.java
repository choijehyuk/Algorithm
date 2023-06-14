import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int r, c, move;

		public Point(int r, int c, int move) {
			this.r = r;
			this.c = c;
			this.move = move;
		}
	}

	static int N;
	static int[][] map;
	static int[] dr = { 0, 1 };
	static int[] dc = { 1, 0 };
	static boolean[][] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(0, 0, map[0][0]);
		System.out.println("Hing");

	}

	private static void bfs(int r, int c, int move) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c, move));
		v[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.r == N - 1 && p.c == N - 1) {
				System.out.println("HaruHaru");
				System.exit(0);
			}

			for (int d = 0; d < 2; d++) {
				int nr = p.r + dr[d] * p.move;
				int nc = p.c + dc[d] * p.move;

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if(!v[nr][nc]) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc, map[nr][nc]));					
				}

			}
		}
	}

}
