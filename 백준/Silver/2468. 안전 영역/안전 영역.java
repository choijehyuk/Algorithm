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

	static int N;
	static int[][] map;
	static int answer = Integer.MIN_VALUE;
	static boolean[][] v;
	static int water = 0;
	static int top;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				top = Math.max(top, map[i][j]);
			}
		}

		// print(map);

		while (water < top) {
			sink();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!v[i][j]) {
						solve(i, j);						
						cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);
			cnt = 0;
			water++;
			v = new boolean[N][N];
		}
		System.out.println(answer);
	}

	private static void sink() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] <= water) {
					v[i][j] = true;
				}
			}
		}
	}

	private static void solve(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		v[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr >=0 && nr < N && nc >=0 && nc < N && !v[nr][nc]) {
					v[nr][nc] = true;
					q.add(new Point(nr,nc));
				}
			}
		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}