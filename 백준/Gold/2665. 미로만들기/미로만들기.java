import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
	static int[][] min;
	static int answer = Integer.MAX_VALUE;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		min = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				min[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - 48;
			}
		}
		// print(map);

		bfs(0, 0);
		System.out.println(min[N-1][N-1]);
		//print(min);
	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		min[r][c] = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1 && min[p.r][p.c] < min[nr][nc]  ) {
					min[nr][nc] = min[p.r][p.c];
					q.add(new Point(nr,nc));
				}
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0 && min[p.r][p.c]+1 < min[nr][nc]) {
					min[nr][nc] = min[p.r][p.c]+1;
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