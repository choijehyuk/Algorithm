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

	static int[][] map;
	static int[] dr = { -1, -1, 0, 1 };
	static int[] dc = { 0, 1, 1, 1, };
	static int ranswer = Integer.MAX_VALUE; // 최소값 찾기
	static int canswer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[19][19];
		StringTokenizer st;
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 검은돌1 , 흰돌2, 알없는곳0
		// print(map);
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				solve(j, i);
			}
		}
		//solve(14,3);
		System.out.println("0");
	}

	private static void solve(int r, int c) {
		int cnt = 0;
		int nr, nc;
		if (map[r][c] == 1) {
			for (int d = 0; d < 4; d++) {
				cnt = 0;
				for (int k = -5; k <= 5; k++) {
					nr = r + dr[d] * k;
					nc = c + dc[d] * k;
					//System.out.println("nr : " + nr + " " + " nc : " + nc);
					if (nr >= 0 && nr < 19 && nc >= 0 && nc < 19) {
						if(cnt == 5 && map[nr][nc] != 1) {
							break;
						}
						
						if(map[nr][nc] == 1) {
							cnt++;							
						}
						else {
							cnt = 0;
						}
					}
				}
				//System.out.println(cnt + "---");
				if (cnt == 5) {
					System.out.println("1");
					System.out.println((r+1) + " " + (c+1));
					System.exit(0);
				}

			}
		} else if (map[r][c] == 2) {
			for (int d = 0; d < 4; d++) {
				cnt = 0;
				for (int k = -5; k <= 5; k++) {
					nr = r + dr[d] * k;
					nc = c + dc[d] * k;
					if (nr >= 0 && nr < 19 && nc >= 0 && nc < 19) {
						if(cnt == 5 && map[nr][nc] != 2) {
							break;
						}
						if(map[nr][nc] == 2) {
							cnt++;

						}
						else {
							cnt = 0;

						}
					}
				}
				if (cnt == 5) {
					System.out.println("2");
					System.out.println((r+1) + " " + (c+1));
					System.exit(0);
				}

			}
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
