import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Point implements Comparable<Point> {
		int end, weight;

		public Point(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int N, M;
	static ArrayList<Point>[] list;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Point(b,c));
			list[b].add(new Point(a,c));
		}
		
		PriorityQueue<Point> q = new PriorityQueue<>();
		dist[1] = 0;
		q.add(new Point(1,0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(dist[p.end] < p.weight)
				continue;
			
			for (Point np : list[p.end]) {
				int nw = dist[p.end] + np.weight;
				if(dist[np.end] > nw) {
					dist[np.end] = nw;
					q.add(new Point(np.end,nw));
				}
			}
		}
		
		System.out.println(dist[N]);
	}

}