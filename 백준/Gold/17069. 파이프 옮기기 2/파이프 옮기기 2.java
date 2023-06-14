import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static long answer;
	static long[][][] d;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		d = new long[N+1][N+1][3];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//print(map);
		// 가로 대각 세로 
		d[1][2][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 3; j <= N; j++) {
				if(map[i][j] == 1) continue;
				
				d[i][j][0] = d[i][j-1][0] + d[i][j-1][1];
				d[i][j][2] = d[i-1][j][1] + d[i-1][j][2];
				if(map[i][j-1] == 0 && map[i-1][j] == 0) {
					d[i][j][1] = d[i-1][j-1][0] + d[i-1][j-1][1] + d[i-1][j-1][2];
				}
				
			}
		}
		for (int i = 0; i < 3; i++) {
			answer += d[N][N][i];
			//System.out.print(d[N][N][i] + " ");
		}
		
		System.out.println(answer);
		
	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}