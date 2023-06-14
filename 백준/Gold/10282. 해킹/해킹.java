import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Point implements Comparable<Point> {
		int e, w;

		public Point(int e, int w) {
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static int N, D, C;
	static ArrayList<Point>[] list;
	static int[] dist;
	static boolean[] v;
	static int computer;
	static int time;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 노드
			D = Integer.parseInt(st.nextToken()); // 간선
			C = Integer.parseInt(st.nextToken()); // 시작

			list = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			dist = new int[N + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			v = new boolean[N + 1];

			// b가 감염되면 a는 s초뒤에 감염
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				list[b].add(new Point(a, s));
			}
			time = Integer.MIN_VALUE;
			computer = 0;
			djikstra(C);
			//System.out.println(Arrays.toString(dist));
			for (int i = 1; i <= N; i++) {
				if(dist[i] != Integer.MAX_VALUE) {
					time = Math.max(time, dist[i]);
					computer++;
				}
			}
			System.out.println(computer + " " + time);
		}
	}

	private static void djikstra(int start) {
		PriorityQueue<Point> q = new PriorityQueue<>();
		dist[start] = 0;
		q.add(new Point(start, 0));

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (dist[p.e] > p.w)
				continue;

			for (Point np : list[p.e]) {
				int nw = dist[p.e] + np.w;
				if (dist[np.e] > nw) {
					dist[np.e] = nw;
					q.add(new Point(np.e, nw));
				}

			}
		}
	}

}