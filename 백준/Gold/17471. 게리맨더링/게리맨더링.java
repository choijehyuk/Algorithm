import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, E;
	static ArrayList<Integer>[] adj;
	static boolean[] v;
	// static int[][] map;
	static int[] population;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N + 1];
		population = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
			population[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			for (int j = 0; j < num; j++) {
				int b = Integer.parseInt(st.nextToken());
				adj[i].add(b);
				//adj[b].add(i);
			}

		}
		v = new boolean[N + 1];

		recursive(1);
		
		//System.out.println(answer);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	private static void recursive(int idx) {
		if (idx == N + 1) {
			if (check()) {
				int A = 0, B = 0;
				for (int i = 1; i <= N; i++) {
					if (v[i])
						A += population[i];
					else
						B += population[i];
				}

				answer = Math.min(answer, Math.abs(A - B));
			}
			return;
		}
		v[idx] = true;
		recursive(idx + 1);
		v[idx] = false;
		recursive(idx + 1);
	}

	private static boolean check() {
		boolean[] visited = new boolean[N + 1];
		
		int checkA = -1;
		int checkB = -1;
		for (int i = 1; i <= N; i++) {
			if(v[i]) {
				checkA = i;
				break;
			}
		}
		for (int i = 1; i <= N; i++) {
			if(!v[i]) {
				checkB = i;
				break;
			}
		}
		if (checkA == -1 || checkB == -1) return false;
		
		Queue<Integer> q = new LinkedList<>();
		visited[checkA] = true;
		q.add(checkA);
		
		while (!q.isEmpty()) {
			Integer p = q.poll();
			for (int i = 0; i < adj[p].size(); i++) {
				if(visited[adj[p].get(i)]) continue;
				if(!v[adj[p].get(i)]) continue;
				visited[adj[p].get(i)] = true;
				q.add(adj[p].get(i));
			}

		}
		q.add(checkB);
		visited[checkB] = true;
		while (!q.isEmpty()) {
			Integer p = q.poll();
			for (int i = 0; i < adj[p].size(); i++) {
				if(visited[adj[p].get(i)]) continue;
				if(v[adj[p].get(i)]) continue;
				visited[adj[p].get(i)] = true;
				q.add(adj[p].get(i));
			}

		}
		
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}

}
