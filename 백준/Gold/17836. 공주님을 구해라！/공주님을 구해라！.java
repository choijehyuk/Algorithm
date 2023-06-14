import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int r, c, time;

		public Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

	static int N, M, T;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int min;
	static int gramX, gramY;
	static int dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 0은 빈공간 , 1은 벽 , 2는 그람

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					gramX = i;
					gramY = j;
				}
			}
		}
		dist = (N - 1 - gramX) + (M - 1 - gramY);

		bfs(0, 0, 0);
		if (min == Integer.MAX_VALUE) {
			System.out.println("Fail");
		} else {
			if(min <= T) {				
				System.out.println(min);
			}
			else {
				System.out.println("Fail");
			}
		}

	}

	private static void bfs(int r, int c, int time) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c, time));
		v[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.r == N - 1 && p.c == M - 1 && p.time <= T) {
				min = Math.min(p.time, min);
			}
			//System.out.println(p.r + " " + p.c);
			if (p.r == gramX && p.c == gramY) {
				min = Math.min(p.time + dist, min);
			}

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] != 1) {
					q.add(new Point(nr, nc, p.time + 1));
					v[nr][nc] = true;
				}
			}
		}

	}

}