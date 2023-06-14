import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int end, move;

		public Point(int end, int move) {
			this.end = end;
			this.move = move;
		}
	}

	static int N, M;
	static ArrayList<Integer>[] list;
	static boolean[] v;
	static int minNum;
	static int maxdist;
	static int samedist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		v = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		bfs();
		System.out.println(minNum + " " + maxdist + " " + samedist );
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(1,0));
		v[1] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int hide = p.end;
			int dist = p.move;
			
			if(maxdist < dist) {
				maxdist = dist;
				minNum = hide;
				samedist = 1;
			}
			else if( maxdist == dist) {
				minNum = Math.min(minNum, hide);
				samedist++;
			}
			for (int i = 0; i < list[hide].size(); i++) {
				int next = list[hide].get(i);
				if(!v[next]) {
					v[next] = true;
					q.add(new Point(next,dist+1));
				}
			}
		}

	}

}