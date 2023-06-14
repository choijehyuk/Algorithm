import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int r, c, k, cnt;

		public Point(int r, int c, int k, int cnt) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	}

	static int K, W, H;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0, };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] jumpr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] jumpc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static boolean[][][] v;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		v = new boolean[H][W][K + 1];
		// 0 은 평지 1은 장애물
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//print(map);

		bfs(0, 0);
		System.out.println("-1");
	}



	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c, K, 0));
		v[0][0][0] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.r == H - 1 && p.c == W - 1) {
				System.out.println(p.cnt);
				System.exit(0);
				//return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if(nr >=0 && nr < H && nc >=0 && nc < W && !v[nr][nc][p.k] && map[nr][nc] == 0) {
					v[nr][nc][p.k] = true;
					q.add(new Point(nr,nc,p.k, p.cnt+1));
				}
				
			}
			if(p.k > 0) {
				for (int d = 0; d < 8; d++) {
					int nr = p.r + jumpr[d];
					int nc = p.c + jumpc[d];

					if (nr >= 0 && nr < H && nc >= 0 && nc < W && !v[nr][nc][p.k - 1] && map[nr][nc] == 0) {
						v[nr][nc][p.k - 1] = true;
						q.add(new Point(nr, nc, p.k - 1, p.cnt + 1));
					}

				}
			}

			
			
		}
	}
	
	private static void print(int[][] map2) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}