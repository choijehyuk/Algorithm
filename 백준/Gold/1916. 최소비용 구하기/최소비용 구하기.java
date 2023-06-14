import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Point implements Comparable<Point>{
		int e, cost;

		public Point(int e, int cost) {
			this.e = e;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	static int N, M;
	static ArrayList<Point>[] list;
	static int start, arrive;
	static int[] dist;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Point(b, c));
			//list[b].add(new Point(a, c));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		arrive = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		v = new boolean[N + 1];
		
		
		PriorityQueue<Point> q = new PriorityQueue<>();
		// v[start] = true;
		dist[start] = 0;
		q.add(new Point(start,0));
		while (!q.isEmpty()) {
			Point p = q.poll();

			if (dist[p.e] < p.cost)
				continue;

			//System.out.println(Arrays.toString(dist));
			for (Point np : list[p.e]) {
				int nc = dist[p.e] + np.cost;
				if (nc < dist[np.e]) {
					//System.out.println(np.e + " " + nc);
					dist[np.e] = nc;
					q.add(new Point(np.e, nc));
				}
			}

		}
		System.out.println(dist[arrive]);
	}

}