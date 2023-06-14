import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static class Point{
		int end,cost;
		public Point(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	static int N;
	static ArrayList<Point>[] list;
	static int answer;
	static int max;
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		v = new boolean[N+1];
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Point(b,c));
			list[b].add(new Point(a,c));
		}
		max = Integer.MIN_VALUE;
		
		for (int i = 1; i < N+1; i++) {
			v = new boolean[N+1];
			dfs(i,0);
		}
		System.out.println(max);
		
	}
	private static void dfs(int start, int sum) {
		if(sum > max) {
			max = sum;
			//return;
		}
		
		v[start] = true;
		for (Point p : list[start]) {
			if(!v[p.end]) {
				v[p.end] = true;
		//		System.out.println(p.cost);
				dfs(p.end, sum + p.cost);
			}
		}
		
		
	}

}