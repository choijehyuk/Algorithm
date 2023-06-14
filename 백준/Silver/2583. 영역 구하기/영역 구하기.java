import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
	static int N,M,K;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int cnt;
	static ArrayList list;
	static int area;
	static int[] answer;
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M];
		list = new ArrayList();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = 0;
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		//print(map);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!v[i][j] && map[i][j] == 0) {
					area = 1;
					solve(i,j);
					list.add(area);
					cnt++;
				}
			}
		}
		sb.append(cnt + "\n");
		//System.out.println(list);
		answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = (int) list.get(i);
		}
		Arrays.sort(answer);
		for (int i = 0; i < answer.length; i++) {
			sb.append(answer[i] + " ");
		}
		System.out.println(sb);
		
	}

	private static void solve(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c));
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr >=0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 0) {
					v[nr][nc] = true;
					q.add(new Point(nr,nc));
					area++;
					
				}
			}
			
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
	}

}