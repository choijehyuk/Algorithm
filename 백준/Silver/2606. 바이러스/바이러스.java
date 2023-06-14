import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int node,line;
	static int[][] map;
	static boolean[] v;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		node = Integer.parseInt(br.readLine());
		line = Integer.parseInt(br.readLine());
		
		map = new int[node+1][node+1];
		v = new boolean[node+1];
		
		for (int i = 0; i < line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[b][a] = 1;
		}
		
		solve(1);
		System.out.println(cnt-1);
	}
	private static void solve(int k) {
		v[k] = true;
		cnt++;
		
		for (int i = 0; i <= node; i++) {
			if(map[k][i] == 1 && !v[i]) {
				solve(i);
			}
		}
	}

}
