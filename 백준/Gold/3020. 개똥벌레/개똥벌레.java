import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, H;
	static int[] up;
	static int[] down;
	static int[] map;
	static int destroy = Integer.MAX_VALUE;
	static int space;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		down = new int[H + 1];
		up = new int[H + 1];
		map = new int[H + 1];

		// 짝수일때는 아래서 홀수일때는 위에서
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (i % 2 == 0) {
				down[input]++;
			} else {
				up[input]++;
			}
		}

		for (int i = H; i > 1; i--) {
			down[i - 1] += down[i];
			up[i - 1] += up[i];
		}

		for (int i = 1; i <= H; i++) {
			map[i] = down[i] + up[H - i + 1];

			if (destroy == map[i]) {
				space++;
			}
			if (destroy > map[i]) {
				destroy = map[i];
				space = 1;
			}

		}

		System.out.println(destroy + " " + space);

	}

}