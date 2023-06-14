import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int end, cost;

		public Point(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}

	static int N;
	static ArrayList<Integer>[] list;
	static char[] room;
	static int[] coin;
	static boolean[] v;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			list = new ArrayList[N + 1];
			for (int i = 1; i < N + 1; i++) {
				list[i] = new ArrayList<>();
			}
			room = new char[N + 1];
			coin = new int[N + 1];
			v = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				int cost = Integer.parseInt(st.nextToken());
				room[i] = s.charAt(0); // E 빈방 , L 레프리콘 , T 트롤
				coin[i] = cost;
				// 스타트에 갈수있는방 넣기
				while (st.hasMoreTokens()) {
					int input = Integer.parseInt(st.nextToken());
					if(input == 0) {
						break;
					}
					list[i].add(input);
				}
			}
			flag = false;
			
			bfs(1, 0);
			
			if(flag) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}

	private static void bfs(int r, int money) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, money));
		v[r] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			
			//System.out.println(p.end);
			if(p.end == N) {
				flag = true;
				return;
			}
			
			// 다음꺼가 E , L , T일때
			for (Integer in : list[p.end]) {
				if (v[in]) continue;
				
				// E일때는 그대로 다음에 갈 수 있는거 넣기
				if (room[in] == 'E') {
					v[in] = true;
					q.add(new Point(in, money));
				}
				// L일때는 가격이 더 낮으면 그가격으로 올려주기
				else if (room[in] == 'L') {
					if (coin[in] > p.cost) {
						p.cost = coin[in];
					}
					v[in] = true;
					q.add(new Point(in, p.cost));

				} else if (room[in] == 'T') {
					// 통행료가 더 비싸서 못감
					if(coin[in] > p.cost) {
						
					}
					// 통행료가 낮을 때 지불하고 진행 
					else {
						v[in] = true;
						money = p.cost - coin[in];
						q.add(new Point(in,money));
					}
					
				}
			}
		}
	}
}