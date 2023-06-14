import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Point implements Comparable<Point> {
		int r, c, weight;

		public Point(int r, int c, int weight) {
			this.r = r;
			this.c = c;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int N;
	static int[][] map;
	static int[][] dist;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			map = new int[N][N];
			dist = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			// print(map);
			num++;
			djikstra();
			System.out.println("Problem " + num + ": " + dist[N - 1][N - 1]);
		}
	}

	private static void djikstra() {
		PriorityQueue<Point> q = new PriorityQueue<Point>();
		dist[0][0] = map[0][0];
		q.add(new Point(0, 0, map[0][0]));

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (dist[nr][nc] > dist[p.r][p.c] + map[nr][nc]) {
						dist[nr][nc] = dist[p.r][p.c] + map[nr][nc];
						q.add(new Point(nr, nc, dist[nr][nc]));
					}
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