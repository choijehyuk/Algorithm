import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int E, S, M;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		solve(1,1,1);
		System.out.println(answer);
	}

	private static void solve(int earth, int sun, int moon) {
		answer++;
		if (earth == 16) {
			earth = 1;
		}
		if(sun == 29) {
			sun = 1;
		}
		if(moon == 20) {
			moon = 1;
		}
		if(earth == E && sun == S && moon == M) {
			return;
		}
		
		solve(earth+1, sun+1, moon+1);
		
	}

}
