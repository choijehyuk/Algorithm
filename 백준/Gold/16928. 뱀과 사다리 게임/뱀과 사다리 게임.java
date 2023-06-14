import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int r, cnt;

		public Point(int r, int cnt) {
			this.r = r;
			this.cnt = cnt;
		}
	}

	static int N, M;
	static int[] move;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		move = new int[101];
		v = new boolean[101];
		// 1시작 100 종료
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			move[start] = end;
		}
		// System.out.println(Arrays.toString(move));
		solve(1,0);
	}

	private static void solve(int r, int cnt) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,cnt));
		v[r] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 1; i <= 6; i++) {
				int nr = p.r + i;
				
				if(p.r >= 100) {
					//System.out.println(Arrays.toString(v));
					System.out.println(p.cnt);
					System.exit(0);
				}
				
				if(nr <=100 && !v[nr]) {
					if(move[nr] != 0) {
						for (int j = 0; j <= move[nr]; j++) {
							v[move[nr]] = true;
						}
						//v[move[nr]] = true;
						q.add(new Point(move[nr],p.cnt+1));
					}
					else {
						v[nr] = true;
						q.add(new Point(nr,p.cnt+1));
					}
				}

				
			}
		}
		
	}

}