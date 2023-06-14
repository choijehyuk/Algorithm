import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r=r;
			this.c=c;	
		}
	}
	static int N,M;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int cnt;
	static int area;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!v[i][j] && map[i][j] == 1) {
					solve(i,j);
					cnt++;
				}
			}
		}
		if(cnt == 0) {
			max = 0;
		}
		System.out.println(cnt);
		System.out.println(max);
		
	}
	private static void solve(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c));
		v[r][c] = true;
		area = 1;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr >=0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 1) {
					v[nr][nc] = true;
					q.add(new Point(nr,nc));
					area++;
				}
			}
		}
		max = Math.max(max, area);
	}
	

}