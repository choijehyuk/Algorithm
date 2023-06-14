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

	static int N, M, R;
	static int[] item;
	static int max = Integer.MIN_VALUE;
	static int dist[];
	static ArrayList<Point>[] list;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 노드의 수
		M = Integer.parseInt(st.nextToken()); // 수색 범위
		R = Integer.parseInt(st.nextToken()); // 간선의 수

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		v = new boolean[N + 1];
		item = new int[N + 1]; // 얻을 수 있는 아이템

		
		// 각노드의 아이템 
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list[start].add(new Point(end, cost));
			list[end].add(new Point(start, cost));
		}
		// 각 노드 별로 다익스트라 돌리고
		// 체크로 거리내에 있는거 합구하기 
		for (int i = 1; i <= N; i++) {
			dist = new int[N + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			djikstra(i);	
			distcheck();
		}
		System.out.println(max);

	}

	private static void distcheck() {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			if(dist[i] <= M) {
				sum += item[i];
			}
		}
		max = Math.max(max, sum);
	}

	private static void djikstra(int start) {
		PriorityQueue<Point> q = new PriorityQueue<>();
		v[start] = true;
		dist[start] = 0;
		q.add(new Point(start, 0));

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (dist[p.e] < p.w)
				continue;

			for (Point np : list[p.e]) {
				if (dist[np.e] > dist[p.e] + np.w) {
					dist[np.e] = dist[p.e] + np.w;
					q.add(new Point(np.e, dist[p.e] + np.w));
				}
			}
		}
	}

}