import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	// 우하좌상
	// -1-1 , -11, 11, 1-1
	static int sangX, sangY;
	static int kingX, kingY;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] ddr = { -1, -1, 1, 1 };
	static int[] ddc = { -1, 1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		sangX = Integer.parseInt(st.nextToken());
		sangY = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		kingX = Integer.parseInt(st.nextToken());
		kingY = Integer.parseInt(st.nextToken());

		map = new int[10][9];
		v = new boolean[10][9];
		map[kingX][kingY] = 1;

		bfs(sangX, sangY);
		// 못갈때
		System.out.println("-1");
	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c, 0));
		v[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
            
            // 왕을 만났을때
			if (map[p.r][p.c] == 1) {
				System.out.println(p.cnt);
				System.exit(0);
			}
			// 상우하좌
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				// 상하좌우 범위밖
				if (!check(nr, nc)) {
					continue;
				}
				//System.out.println(nr + " " + nc);
				// 중간에 막힐때
				if (map[nr][nc] == 1) {
					continue;
				}
				for (int i = 0; i < 2; i++) {
					// 대각 한번
					int dir = (d + i) % 4;
					int nnr = nr + ddr[dir];
					int nnc = nc + ddc[dir];

					if (!check(nnr, nnc)) {
						continue;
					}
					// 중간에 막힐때
					if(map[nnr][nnc] == 1) {
						continue;
					}
					
					//System.out.println(nnr + " " + nnc + " " + p.cnt);
					// 대각두번
					nnr += ddr[dir];
					nnc += ddc[dir];
					if (check(nnr, nnc) && !v[nnr][nnc]) {
						v[nnr][nnc] = true;
						q.add(new Point(nnr, nnc, p.cnt + 1));
					}

				}

			}
		}

	}
    // 범위 밖
	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < 10 && nc >= 0 && nc < 9) {
			return true;
		} else {
			return false;
		}
	}

}
