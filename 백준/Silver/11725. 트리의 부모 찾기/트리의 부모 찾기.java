import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static ArrayList<Integer>[] list;
	static boolean[] v;
	static int[] answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<>();;
		}
		v = new boolean[N+1];
		answer = new int[N+1];
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		bfs();
		
		for (int i = 2; i < N+1; i++) {
			System.out.println(answer[i]);
		}
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		v[1] = true;
		
		while(!q.isEmpty()) {
			Integer p = q.poll();

			for (Integer next : list[p]) {
				if(!v[next]) {
					v[next] = true;
					answer[next] = p;
					q.add(next);
				}
			}
		}
	}

}