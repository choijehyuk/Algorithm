import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R, C, N;
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("res/봄버맨2.txt"));
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		N = sc.nextInt();
		map = new int[R][C];

		for (int r = 0; r < R; r++) {
			String str = sc.next();
			for (int c = 0; c < C; c++) {
				int a = str.charAt(c) == '.' ? 0 : 3;
				map[r][c] = a;
			}
		}
		
		if (N == 1) {
			reduceTime();
			printAns(map);
			//print(map);
			System.exit(0);
		}
		
		reduceTime();
		N-=1;
		if(N > 4) N = N % 4 + 4;
		for (int cnt = 0; cnt < N; cnt++) {
			reduceTime();
			if (cnt % 2 == 0) {
				rebuild();
			} else if (cnt % 2 == 1) {
				booom();
			}
		}
		//print(map);
		printAns(map);
	}

	private static void reduceTime() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] > 1)
					map[r][c]--;
			}
		}
	}

	private static void rebuild() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 0)
					map[r][c] = 3;
			}
		}
	}

	private static void booom() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 1) {
					map[r][c] = 0;
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 1) {
							map[nr][nc] = 0;
						}
					}
				}
			}
		}
	}
	
	private static void printAns(int[][] map) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if (map[r][c] == 0)
					System.out.print('.');
				else if (map[r][c] > 0)
					System.out.print('O');
			}
			System.out.println();
		}

	}
	
	
	// ------------ test code ------------------------
	private static void booom2() {
		ArrayList<Point> list = new ArrayList();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 1) {
					list.add(new Point(r,c));
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			map[p.r][p.c]=0;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					map[nr][nc] = 0;
				}
			}
		}
	}
	
	static class Point{
		int r, c;
		Point(int r,int c){
			this.r=r;
			this.c=c;
		}
	}
	

	private static void print(int[][] map) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}