import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int white, blue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void solve(int r, int c, int size) {
		
		if(check(r,c,size)) {
			if(map[r][c] == 0) {
				white++;
			}
			else {
				blue++;
			}
			return;
		}
		
		int half = size / 2;
		solve(r,c+half,half);
		solve(r,c,half);
		solve(r+half,c,half);
		solve(r+half,c+half,half);
		
		
	}

	private static boolean check(int r, int c, int size) {
		
		int color = map[r][c];
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}

	

}