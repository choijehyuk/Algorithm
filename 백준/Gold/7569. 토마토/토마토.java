import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int M, N, H;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<Point> q;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		// N :행 , M : 열 , H : 높이
		map = new int[N * H][M];
		// 익은 토마토 1 , 안익은 토마토 0
		v = new boolean[N * H][M];
		q = new LinkedList<>();
		
		for (int i = 0; i < N * H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.add(new Point(i, j, 0));
				}
			}
		}

		// 처음부터 모두 익어있으면 0 출력하고 종료
		end();

		bfs();
		System.out.println("-1");
		// print(map);

	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
//			print(map);
//			System.out.println("---");
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				answer = p.cnt;

				int div = p.r / N;
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					// 3 5 2
					// N M H
					// [3*2][5]
					// (3,1) div = 1
					if (nr < div * N || nr >= (div * N + N) || nc < 0 || nc >= M)
						continue;
					if (!v[nr][nc] && map[nr][nc] == 0) {
						v[nr][nc] = true;
						map[nr][nc] = 1;
						q.add(new Point(nr, nc, p.cnt + 1));
					}
				}
				// System.out.println("pr " + p.r);
				int up = p.r + N;
				int down = p.r - N;
				// System.out.println("down " + down);
				// System.out.println(up);
				if ((up < N * H && !v[up][p.c] && map[up][p.c] == 0)) {
					v[up][p.c] = true;
					map[up][p.c] = 1;
					q.add(new Point(up, p.c, p.cnt + 1));
				}
				if (down >= 0 && !v[down][p.c] && map[down][p.c] == 0) {
					v[down][p.c] = true;
					map[down][p.c] = 1;
					q.add(new Point(down, p.c, p.cnt + 1));
				}

			}
		}

		end();
	}

	private static void end() {
		int tomato = 0;
		for (int i = 0; i < N * H; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					tomato++;
				}
			}
		}
		if (tomato == 0) {
			System.out.println(answer);
			System.exit(0);
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < N * H; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}