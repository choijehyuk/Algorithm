import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int end, cost;

		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	static int N, M;
	static ArrayList<Node>[] adj;
	static boolean[] v;
	static long allroad; // 모든 도로를 설치할 때 비용
	static int dist[];
	static long answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
		v = new boolean[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a, c));
			allroad += c;
		}
		
		PriorityQueue<Node> q = new PriorityQueue<Main.Node>();
		int cnt = 0;
		long sum = 0;
		//v[0] = true;
		q.add(new Node(1, 0));
		while (!q.isEmpty()) {
			if (cnt == N)
				break;
			Node n = q.poll();
			//System.out.println(n.end + " " + n.cost);
			if (v[n.end])
				continue;
			v[n.end] = true;
			sum += n.cost;
			cnt++;
			for (Node node : adj[n.end]) {
				if(v[node.end] == false && node.cost < dist[node.end]) {
					dist[node.end] = node.cost;
				}
				q.add(new Node(node.end, dist[node.end]));
			}
		}
		if(cnt == N) {
			answer = allroad - sum;			
			System.out.println(answer);
		}
		else {
			System.out.println("-1");
		}


//		PriorityQueue<Node> q = new PriorityQueue<Main.Node>();
//		int cnt = 1;
//		int sum = 0;
//		q.addAll(adj[0]);
//		while(cnt < M*2) {
//			Node n = q.poll();
//			System.out.println(n.start + " " + n.end + " " + n.cost);
//			if(dist[n.end] > n.cost) {
//				dist[n.end] = n.cost;				
//			}
//			q.addAll(adj[cnt]);
//			cnt++;
//		}
//		
//		System.out.println(Arrays.toString(dist));
//	}

	}
}
