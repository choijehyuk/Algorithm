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

	static int L, R, C;
	static char[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean flag;
	static int startX, startY;
	static int endX, endY;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());

			L = Integer.parseInt(st.nextToken()); // 높이
			R = Integer.parseInt(st.nextToken()); // 행
			C = Integer.parseInt(st.nextToken()); // 열
			// 종료
			if (L == 0 && R == 0 && C == 0) {
				break;
			}
			map = new char[L * R][C];
			v = new boolean[L * R][C];
			flag = false;
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < L * R; i++) {
				if (i % R == 0 && i != 0) {
					String dummy = br.readLine();
				}
				String s = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == 'S') {
						startX = i;
						startY = j;
					}
					if (map[i][j] == 'E') {
						endX = i;
						endY = j;
					}
				}
			}
			String dummy = br.readLine();
			// System.out.println(startX + " " + startY + " " + endX + " " + endY);

			// print(map);

			bfs(startX, startY, 0);
			if (flag) {
				System.out.println("Escaped in " + answer + " minute(s).");
			} else {
				System.out.println("Trapped!");
			}
		}
	}

	private static void bfs(int r, int c, int time) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c, time));
		v[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			//System.out.println(p.r + " " + p.c);
			if (p.r == endX && p.c == endY) {
				flag = true;
				answer = Math.min(answer, p.time);
			}
			int div = p.r / R;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr >= div * R && nr < (div * R + R) && nc >= 0 && nc < C && !v[nr][nc] && map[nr][nc] != '#') {
					q.add(new Point(nr, nc, p.time + 1));
					v[nr][nc] = true;
				}
			}
			int up = p.r + R;
			int down = p.r - R;

			if (up < R * L && !v[up][p.c] && map[up][p.c] != '#') {
				v[up][p.c] = true;
				q.add(new Point(up, p.c, p.time + 1));
			}
			if (down >= 0 && !v[down][p.c] && map[down][p.c] != '#') {
				v[down][p.c] = true;
				q.add(new Point(down, p.c, p.time + 1));
			}
		}
	}

	private static void print(char[][] map) {
		for (int i = 0; i < L * R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}