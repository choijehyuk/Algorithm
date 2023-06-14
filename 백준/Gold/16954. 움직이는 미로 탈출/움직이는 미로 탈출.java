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

	static char[][] map;
	static boolean[][] v;
	static int[] dr = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[8][8];
		v = new boolean[8][8];

		for (int i = 0; i < 8; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				map[i][j] = c[j];
			}
		}
		// print(map);

		bfs(7, 0);
		System.out.println(0);
	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		v[r][c] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				Point p = q.poll();

				if (map[p.r][p.c] == '#')
					continue;
				
				for (int d = 0; d < 9; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];

					if (nr == 0 && nc == 7) {
						System.out.println(1);
						System.exit(0);
					}
					
					if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8 && map[nr][nc] != '#') {
						q.add(new Point(nr, nc));
					}
				}
			}
			down();
		}
	}

	private static void down() {
		for (int i = 6; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				map[i + 1][j] = map[i][j];
			}
		}
		for (int i = 0; i < 8; i++) {
			map[0][i] = '.';
		}
	}

	private static void print(char[][] map) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}