import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
			return this.w - o.w;
		}
	}

	static int N, M, X;
	static ArrayList<Point> list[];
	static ArrayList<Point> backlist[];
	static int dist[];
	static int backdist[];
	static int max = Integer.MAX_VALUE;
	static boolean[] v;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		backlist = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
			backlist[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[start].add(new Point(end, weight));
			backlist[end].add(new Point(start, weight));
		}

		int time[] = solve(list);
		int backtime[] = solve(backlist);

		for (int i = 0; i < N + 1; i++) {
			answer = Math.max(answer, time[i] + backtime[i]);
		}
		System.out.println(answer);
	}

	private static int[] solve(ArrayList<Point>[] list) {
		PriorityQueue<Point> q = new PriorityQueue<>();
		v = new boolean[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		q.add(new Point(X, 0));

		while (!q.isEmpty()) {
			Point p = q.poll();
			
			if (v[p.e])
				continue;
			v[p.e] = true;

			for (Point point : list[p.e]) {
				if (dist[point.e] > point.w + p.w) {
					dist[point.e] = point.w + p.w;
					q.add(new Point(point.e, dist[point.e]));
				}
			}
		}

		return dist;
	}
}