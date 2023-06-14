import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int F, S, G, U, D;
	static boolean[] v;
	static int answer = 0;
	static class Point {
		int floor;
		int cnt;

		public Point(int floor, int cnt) {
			super();
			this.floor = floor;
			this.cnt = cnt;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken()); // 건물높이
		S = Integer.parseInt(st.nextToken()); // 강호가 지금 있는 층
		G = Integer.parseInt(st.nextToken()); // 스타트링크 위치
		U = Integer.parseInt(st.nextToken()); // 위로
		D = Integer.parseInt(st.nextToken()); // 아래로
		v = new boolean[F + 1];

		answer = bfs();

		if (answer >= 0) {
			System.out.println(answer);
		} else {
			System.out.println("use the stairs");
		}

	}

	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(S, 0));
		v[S] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.floor == G) {
				return p.cnt;
			}
			if (p.floor + U <= F && !v[p.floor + U]) {
				q.offer(new Point(p.floor + U, p.cnt + 1));
				v[p.floor + U] = true;
			}
			if (p.floor - D > 0 && !v[p.floor - D]) {
				q.offer(new Point(p.floor - D, p.cnt + 1));
				v[p.floor - D] = true;
			}

		}
		return -1;

	}

}
