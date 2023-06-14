import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

	static int R, C, N;
	static char[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static ArrayList<Point> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		list = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'O') {
					list.add(new Point(i, j));
				}
			}
		}
		if (N == 1) {
			print(map);
			System.exit(0);
		}
		if (N % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = 'O';
				}
			}
			print(map);
			System.exit(0);
		}
		while (N >= 3) {
			list = new ArrayList<>();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 'O') {
						list.add(new Point(i, j));
					}
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = 'O';
				}
			}

			for (int i = 0; i < list.size(); i++) {
				map[list.get(i).r][list.get(i).c] = '.';
				for (int d = 0; d < 4; d++) {
					int nr = list.get(i).r + dr[d];
					int nc = list.get(i).c + dc[d];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
						map[nr][nc] = '.';
					}
				}
			}
			N -= 2;

		}
		print(map);

	}

	private static void print(char[][] map) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}