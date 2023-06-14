import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
	S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
	L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
	R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.
 */
public class Main {

	static class Point {
		int n;
		String s;

		public Point(int n, String s) {
			this.n = n;
			this.s = s;
		}
	}

	static int T;
	static int N;
	static int convert;
	static int d1, d2, d3, d4;
	static StringBuffer sb;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuffer();
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			convert = Integer.parseInt(st.nextToken());
			v = new boolean[10000];
			// D : 2배 , 10000보다 크면 나머지
			// S : N-1 , N이 0 이면 9999
			// L 은 왼쪽으로 회전
			// R 은 오른쪽으로 회전
			// 0 ,1 ,2 ,3

//			d1 = N / 1000;
//			d2 = N / 100 - d1 * 10;
//			d3 = N / 10 - d1 * 100 - d2 * 10;
//			d4 = N % 10;

			bfs(N);
		}
	}

	private static void bfs(int n) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(n, ""));
		v[n] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			int num = p.n;
			d1 = p.n / 1000;
			d2 = p.n / 100 - d1 * 10;
			d3 = p.n / 10 - d1 * 100 - d2 * 10;
			d4 = p.n % 10;
			if (p.n == convert) {
				System.out.println(p.s);
				return;
			}
			for (int d = 0; d < 4; d++) {
				if (d == 0) {
					num = 2 * num % 10000;
					if (v[num])
						continue;
					v[num] = true;
					q.add(new Point(num, p.s + "D"));
				} else if (d == 1) {
					num = p.n - 1;
					if (num == -1) {
						num = 9999;
					}
					if (v[num])
						continue;
					v[num] = true;
					q.add(new Point(num, p.s + "S"));
				} else if (d == 2) {
					num = d2 * 1000 + d3 * 100 + d4 * 10 + d1;
					if (v[num])
						continue;
					v[num] = true;
					q.add(new Point(num, p.s + "L"));
				} else if (d == 3) {
					num = d4 * 1000 + d1 * 100 + d2 * 10 + d3;
					if (v[num])
						continue;
					v[num] = true;
					q.add(new Point(num, p.s + "R"));

				}
			}
		}
	}

}