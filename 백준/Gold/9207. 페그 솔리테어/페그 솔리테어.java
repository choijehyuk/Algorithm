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

	static int N;
	static char[][] map;
	static int minpin;
	static int minmove;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int pin;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < N; tc++) {
			map = new char[5][9];
			v = new boolean[5][9];
			pin = 0;
			minmove = Integer.MAX_VALUE;
			for (int i = 0; i < 5; i++) {
				String s = br.readLine();
				for (int j = 0; j < 9; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == 'o') {
						pin++;
					}
				}
			}
			minpin = pin;
			// 한줄 씩 띄워서 입력
			String dummy = br.readLine();

			// print(map);
			// 핀찾아서 dfs
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 9; j++) {
					if (map[i][j] == 'o') {
						dfs(i, j, pin, 0);
					}
				}
			}
			System.out.println(minpin + " " + minmove);

		}

	}

	private static void dfs(int r, int c, int pinnum, int movecnt) {
		// 핀의 개수가 적어지면 최소핀 재설정 , 이동횟수 바꿔주기
		if (minpin > pinnum) {
			minpin = pinnum;
			minmove = movecnt;
		}
		// 같을때는 이동횟수 적은거로
		if (minpin == pinnum) {
			minmove = Math.min(minmove, movecnt);
		}
		// 사방
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < 5 && nc >= 0 && nc < 9 && map[nr][nc] == 'o') {

				if (d == 0) { // 상
					int nnr = nr - 1;
					int nnc = nc;
					if (nnr >= 0 && map[nnr][nnc] == '.') { // 점프하는 곳이 범위안 , 빈공간이면
						map[r][c] = '.'; // 원래자리 빈공간
						map[nr][nc] = '.'; // 인접핀 제거
						map[nnr][nnc] = 'o'; // 점프뛴곳 핀놓기
						// 맵 다시 만들어주고 다시 핀찾아서 dfs
						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 9; j++) {
								if (map[i][j] == 'o') {
									dfs(i, j, pinnum - 1, movecnt + 1);
								}
							}
						}
						// 백트래킹
						map[r][c] = 'o';
						map[nr][nc] = 'o';
						map[nnr][nnc] = '.';
					}
				} else if (d == 1) { // 우
					int nnr = nr;
					int nnc = nc + 1;
					if (nnc < 9 && map[nnr][nnc] == '.') {
						map[r][c] = '.';
						map[nr][nc] = '.';
						map[nnr][nnc] = 'o';
						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 9; j++) {
								if (map[i][j] == 'o') {
									dfs(i, j, pinnum - 1, movecnt + 1);
								}
							}
						}
						map[r][c] = 'o';
						map[nr][nc] = 'o';
						map[nnr][nnc] = '.';
					}
				} else if (d == 2) { // 하
					int nnr = nr + 1;
					int nnc = nc;
					if (nnr < 5 && map[nnr][nnc] == '.') {
						map[r][c] = '.';
						map[nr][nc] = '.';
						map[nnr][nnc] = 'o';
						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 9; j++) {
								if (map[i][j] == 'o') {
									dfs(i, j, pinnum - 1, movecnt + 1);
								}
							}
						}
						map[r][c] = 'o';
						map[nr][nc] = 'o';
						map[nnr][nnc] = '.';
					}
				} else if (d == 3) { // 좌
					int nnr = nr;
					int nnc = nc - 1;
					if (nnc >= 0 && map[nnr][nnc] == '.') {
						map[r][c] = '.';
						map[nr][nc] = '.';
						map[nnr][nnc] = 'o';
						for (int i = 0; i < 5; i++) {
							for (int j = 0; j < 9; j++) {
								if (map[i][j] == 'o') {
									dfs(i, j, pinnum - 1, movecnt + 1);
								}
							}
						}
						map[r][c] = 'o';
						map[nr][nc] = 'o';
						map[nnr][nnc] = '.';
					}
				}
			}
		}

	}

	private static void print(char[][] map) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}