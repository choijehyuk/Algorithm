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

	static int w, h;
	static char[][] map;
	static int answer;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] v;
	static Queue<Point> sang;
	static Queue<Point> fire;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			v = new boolean[h][w];
			sang = new LinkedList<>();
			fire = new LinkedList<>();
			answer = Integer.MAX_VALUE;
			// . 빈공간 , # 벽 , @ 상근이 위치 , * 불
			for (int i = 0; i < h; i++) {
				String s = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '@') {
						sang.add(new Point(i,j,0));
						map[i][j] = '.';
					}
					if(map[i][j] == '*') {
						fire.add(new Point(i,j,0));
					}
 				}
			}
			//print(map);
			
			bfs();
			
			System.out.println(answer == Integer.MAX_VALUE? "IMPOSSIBLE" : answer);
			
			
			
		}
	}

	private static void bfs() {
		while(!sang.isEmpty()) {
//			print(map);
//			System.out.println("--");
			int size = fire.size();
			for (int i = 0; i < size; i++) {
				Point p = fire.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					
					if(nr >= 0 && nr < h && nc >= 0 && nc < w && (map[nr][nc] == '.' || map[nr][nc] == '@')) {
						map[nr][nc] = '*';
						fire.add(new Point(nr,nc,p.cnt+1));
					}
				}
			}
			
			size = sang.size();
			for (int i = 0; i < size; i++) {
				Point p = sang.poll();
				
				if(p.r == h-1 || p.c == w-1 || p.r == 0 || p.c== 0) {
					answer = p.cnt+1;
					return;
				}
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					
					if(nr >= 0 && nr < h && nc >=0 && nc < w && !v[nr][nc] && map[nr][nc] == '.') {
						map[nr][nc] = '@';
						v[nr][nc] = true;
						sang.add(new Point(nr,nc,p.cnt+1));
					}
				}
			}
		}
	}

	private static void print(char[][] map) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}