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

	static int R, C;
	static char[][] map;
	static boolean[][] v;
	static int answer;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<Point> jh;
	static Queue<Point> fire;
	static int startX, startY;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// # 벽 , .  지나갈 수 있는 공간 , J 지훈이의 위치 , F 불이난 공간
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		v = new boolean[R][C];
		jh = new LinkedList<>();
		fire = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'J') {
					jh.add(new Point(i,j,0));
					startX = i;
					startY = j;
					map[i][j] = '.';
					
				}
				if(map[i][j] == 'F') {
					fire.add(new Point(i,j,0));
				}
			} 
		}
		//print(map);
		
		bfs();
		System.out.println("IMPOSSIBLE");
		
	}

	private static void bfs() {
		
		while(!jh.isEmpty()) {
			int size = fire.size();
			for (int i = 0; i < size; i++) {
				Point p = fire.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					
					if(nr >=0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
						map[nr][nc] = 'F';
						fire.add(new Point(nr,nc,p.cnt+1));
					}
				}
			}
			
			size = jh.size();
			for (int i = 0; i < size; i++) {
				Point p = jh.poll();
				if(p.r == R-1 || p.c == C-1 || p.r == 0 || p.c == 0) {
					System.out.println(p.cnt+1);
					System.exit(0);
				}
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					
					if(nr >=0 && nr < R && nc >= 0 && nc < C && !v[nr][nc] && map[nr][nc] == '.') {
						v[nr][nc] = true;
						jh.add(new Point(nr,nc,p.cnt+1));
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