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

	static int N, Q;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int sum;
	static int max;
	static int[] turn;
	static int size;
	static int[][] turnmap;
	static int[][] checkmap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		size = (int) Math.pow(2, N);
		map = new int[size][size];
		turn = new int[Q];
		v = new boolean[size][size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			turn[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < Q; i++) {
			splitmap(turn[i]);
			melt();
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!v[i][j] && map[i][j] != 0) {
					bfs(i, j);
				}
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sum += map[i][j];
			}
		}

		System.out.println(sum);
		System.out.println(max);

	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		v[r][c] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr >= 0 && nr < size && nc >= 0 & nc < size && !v[nr][nc] && map[nr][nc] != 0) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc));
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}

	}

	private static void melt() {
		checkmap = new int[size][size];
		copycheckmap();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];

					if (nr >= 0 && nr < size && nc >= 0 && nc < size && checkmap[nr][nc] != 0) {
						cnt++;
					}
				}
				if (cnt < 3) {
					if (map[i][j] > 0) {
						map[i][j]--;
					}
				}
			}
		}

	}

	private static void splitmap(int s) {
		turnmap = new int[size][size];
		int div = (int) Math.pow(2, s);
		int arrsize = size / div;

		copyturnmap();

		for (int i = 0; i < arrsize; i++) {
			for (int j = 0; j < arrsize; j++) {
				turnmap(i * div, j * div, div, turnmap);
			}
		}
	}

	private static void copyturnmap() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				turnmap[i][j] = map[i][j];
			}
		}
	}

	private static void copycheckmap() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				checkmap[i][j] = map[i][j];
			}
		}
	}

	private static void turnmap(int r, int c, int div, int[][] turnmap) {
		for (int i = 0; i < div; i++) {
			for (int j = 0; j < div; j++) {
				map[j + r][c + div - i - 1] = turnmap[i + r][j + c];
			}
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}