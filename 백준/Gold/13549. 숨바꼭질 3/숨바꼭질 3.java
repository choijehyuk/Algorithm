import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int v[];

	static class Point {
		int n;
		int cnt;

		public Point(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}

	}

	static int fast = Integer.MAX_VALUE;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();
		System.out.println(fast);
		//System.out.println(cnt);
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(N, 0));
		v = new int[100001];
		v[N] = 1;
		while (!q.isEmpty()) {
			Point p = q.poll();
			int pn = p.n;
			if (pn == K) {
				// System.out.println(fast + " " + p.cnt);
				fast = Math.min(fast, p.cnt);
			}

			pn = 0;
			if(p.n < 100) {
				//System.out.println(p.n + " " + p.cnt);
			}
			pn = p.n * 2;
			if (pn >= 0 && pn < 100001) {
				if (v[pn] == p.cnt + 1 || v[pn] == 0) {
					q.offer(new Point(pn, p.cnt));
					v[pn] = p.cnt;
				}
			}
			
			pn = p.n + 1;
			if (pn >= 0 && pn < 100001) {
				if (v[pn] == p.cnt + 1 || v[pn] == 0) {
					q.offer(new Point(pn, p.cnt + 1));
					v[pn] = p.cnt;
				}
			}
			
			pn = p.n - 1;
			if (pn >= 0 && pn < 100001) {
				if (v[pn] == p.cnt + 1 || v[pn] == 0) {
					q.offer(new Point(pn, p.cnt + 1));
					v[pn] = p.cnt;
				}
			}
		}
	}

}
