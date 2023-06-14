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

	static int M, N;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		v = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}

		// print(map);
		for (int i = 0; i < N; i++) {
			solve(0, i);
		}
		System.out.println("NO");

	}

	private static void solve(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		v[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			
			
			if(p.r == M-1) {
				System.out.println("YES");
				System.exit(0);
			}
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr >=0 && nr < M && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] != 1) {
					q.add(new Point(nr,nc));
					v[nr][nc] = true;	
				}
			}
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}