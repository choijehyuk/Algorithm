import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 로봇 청소기와 방의 상태가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램
 * 로봇 청소기가 있는 방 : N * M , 각각의 칸은 벽 또는 빈칸
 * 청소기가 바라보는 방향은 동서남북
 * 처음에 빈칸은 전부 청소되지 않은 상태
 * 현재칸이 청소안된경우 -> 현재칸 청소
 * 4방향중 청소되지 않은 빈칸이 없는경우 후진 , 벽이면 중지
 * 4방향중 청소되지 않은 빈 칸이 있는 경우 -> 반시계로 90도 회전 , 앞쪽 칸이 청소되지 않았으면 한칸 전진 
 * 첫줄에 N , M 입력 , 다음줄에 r,c와 바라보는 방향 d , 0 : 북 , 1 : 동 , 2 : 남 , 3 : 서 
 * 0이면 청소되지 않은칸 , 1이면 벽 
 */
public class Main {
	static class Point {
		int r, c, d;

		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static int N, M;
	static int r, c, d;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dc = { 0, 1, 0, -1 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// print(map);
		solve(r, c, d);
		System.out.println(answer);
//		print(map);
	}

	private static void solve(int r, int c, int d) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c, d));
//		map[r][c] = 2;
		while (!q.isEmpty()) {
			Point p = q.poll();
//			System.out.println("현재 좌표");
//			System.out.println("row : " + p.r + " col : " + p.c + " dir : " + p.d);
			int dir = p.d;
			// System.out.println(nr + " " + nc + " " + dir);
			if (map[p.r][p.c] == 0) {
				map[p.r][p.c] = 2; // 청소 안되어 있으면 청소
				answer++;
			}
			// print(map);
			int cnt = 0;
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if(map[nr][nc] == 0) cnt++;
			}
			
			// 청소할 칸이 없음
			if(cnt == 0) {
				// 후진 여부 판단
				int watchR = p.r + dr[(dir + 2) % 4];
				int watchC = p.c + dc[(dir + 2) % 4];
				
				if(map[watchR][watchC] == 1) {
					break;
				}
				else {
					q.add(new Point(watchR, watchC, dir));
//					System.out.println("후진 완료");
//					System.out.println("row : " + watchR + " col : " + watchC + " dir : " + p.d);
				}
			}
			
			// 청소할 칸이 있음
			else {
				// 반시계로 회전 완료
				dir = (dir + 3) % 4;
				
				// 바라보는 방향 기준 앞 칸 지도 확인
				int nr = p.r + dr[dir];
				int nc = p.c + dc[dir];
				
				if(map[nr][nc] == 0) {
					q.add(new Point(nr, nc, dir));
				}
				else {
					q.add(new Point(p.r, p.c, dir));
				}

			}
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
