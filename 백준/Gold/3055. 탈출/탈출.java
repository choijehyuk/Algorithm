import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

지도는 R행 C열
비어있는곳 .
물이 차있는곳 *
돌 X
비버굴 D
고슴도치 S
*/
public class Main {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int R, C;
	static char[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int startX, startY;
	static int endX, endY;
	static int cnt;
	static int answer; 
	static Queue<Point> q;
	static Queue<Point> qq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		v = new boolean[R][C];

		q = new LinkedList<>();
		qq = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'D') {
					endX = i;
					endY = j;
				}
				if (map[i][j] == 'S') {
					startX = i;
					startY = j;
					q.add(new Point(i, j));
				}
				if (map[i][j] == '*') {
					qq.add(new Point(i, j));

				}
			}
		}
		// print(map);
		// System.out.println(startX + " " + startY);
		// System.out.println(endX + " " + endY);

		solve(startX, startY);
		System.out.println("KAKTUS");
		//System.out.println(cnt);
	}

	private static void solve(int r, int c) {
		while (!q.isEmpty()) {
			cnt++;
			int len = qq.size();
			for (int i = 0; i < len; i++) {
				Point pp = qq.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = pp.r + dr[d];
					int nc = pp.c + dc[d];
					
					if(nr >=0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
						map[nr][nc] = '*';
						qq.add(new Point(nr,nc));
					}
				}
			}
//			print(map);
//			System.out.println("--");
			if(q.size() == 0) {
				System.out.println("KAKTUS");
				System.exit(0);
			}
			
			len = q.size();
			for (int i = 0; i < len; i++) {
				Point p = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					
					if(nr >=0 && nr < R && nc >= 0 && nc < C) { 
//						if(map[nr][nc] == 'D') {
//							return;
//						}
						if(nr == endX && nc == endY) {
							System.out.println(cnt);
							System.exit(0);
						}
						else if( map[nr][nc] == '.') {
							map[nr][nc] = 'S';
							q.add(new Point(nr,nc));
						}
					}
				}
			}

		}
	}



	private static void print(char[][] map) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}