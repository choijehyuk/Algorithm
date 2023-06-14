import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M;
	static int[][] map;
	static boolean[] v;
	static ArrayList<Point> home;
	static ArrayList<Point> chicken;
	static int answer;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					home.add(new Point(i,j));
				}
				if(map[i][j] == 2) {
					chicken.add(new Point(i,j));
				}
			}
		}
		
		v = new boolean[chicken.size()];
		
		solve(0,0);
		System.out.println(answer);
		
		
		
	}
	private static void solve(int idx, int cnt) {
		if(cnt == M) {
			//System.out.println(Arrays.toString(v));
			
			int sum = 0;
			for (int i = 0; i < home.size(); i++) {
				int distance = 0;
				min = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if(v[j]) {						
						distance = (Math.abs(home.get(i).r - chicken.get(j).r)) + (Math.abs(home.get(i).c - chicken.get(j).c));
						min = Math.min(min, distance);
					}
				}
				sum += min;
			}
			answer = Math.min(sum, answer);
			
			return;
		}
		
		for (int i = idx; i < v.length; i++) {
			v[i] = true;
			solve(i+1,cnt+1);
			v[i] = false;
		}
	}
}