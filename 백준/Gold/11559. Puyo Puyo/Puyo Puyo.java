import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N = 12;
	static int M = 6;
	static char[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int answer;
	static boolean boomcheck;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		// print(map);

		while (true) {
			v = new boolean[N][M];
			boomcheck = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != '.' && !v[i][j]) {
						colorcnt(i, j);
						// print(map);
						// System.out.println("--");
					}
				}
			}
			down();
			if (boomcheck) {
				answer++;
			} else {
				break;
			}
		}
		System.out.println(answer);
	}

	private static void down() {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < M; i++) { // 열
			for (int j = 0; j < N; j++) { // 행
				if (map[j][i] != '.') { // .이 아닌부분 스택에 넣어주기
					stack.push(map[j][i]);
					map[j][i] = '.';
				}
			}

			for (int j = N - 1; j >= 0; j--) { // 배열의 뒤부터 값 넣어주기
				if (stack.size() == 0) { // 스택이 비면 다음 열로
					break;
				}
				map[j][i] = stack.pop();
			}
		}
	}

	// 인접한 곳에 4개 이상이 붙어있는지 체크
	private static void colorcnt(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		v[r][c] = true;
		char color = map[r][c];
		// System.out.println(color);
		int cnt = 1;
		while (!q.isEmpty()) {
			Point p = q.poll();

			// System.out.println(p.r + " " + p.c + " ");
			if (cnt == 4) {
				boom(r, c);
				boomcheck = true;
			}
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if (!isRange(nr, nc))
					continue;

				char colorcheck = map[nr][nc];
				if (!v[nr][nc] && color == colorcheck) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc));
					cnt++;
				}
			}
		}
	}

	// 4개 이상되면 터치기
	private static void boom(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		v = new boolean[N][M];
		v[r][c] = true;
		char color = map[r][c];
		map[r][c] = '.';
		while (!q.isEmpty()) {

			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if (!isRange(nr, nc))
					continue;
				char colorcheck = map[nr][nc];
				if (!v[nr][nc] && color == colorcheck) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc));

					map[nr][nc] = '.';
				}
			}
		}

	}

	private static boolean isRange(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		else
			return false;

	}

	private static void print(char[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}