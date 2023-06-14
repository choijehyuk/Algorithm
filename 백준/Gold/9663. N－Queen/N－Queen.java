import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		solve(0);
		System.out.println(answer);
	}

	/*
	 * Queen : 1 blank : 0;
	 */
	private static void solve(int r) {
		// basis part
		if (r == N) {
			answer++;
			// print(map);
		}

		// inductive part
		for (int c = 0; c < N; c++) {
			if (check(r, c)) {
				map[r][c] = 1;
				solve(r + 1);
				map[r][c] = 0;
			}
		}
	}

	// r,c 위치에 퀸을 놓는 시점에 검사해야 하는 방향은
	// 상 , 좌상 , 우상
	// 퀸이 있으면 false
	// 없으면 true
	private static boolean check(int r, int c) {
		for (int i = 0; i < r; i++) {
			if (map[i][c] == 1)
				return false;
		}

		for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
			if (map[i][j] == 1)
				return false;
		}
		for (int i = r - 1, j = c + 1; i >= 0 && j < N; i--, j++) {
			if (map[i][j] == 1)
				return false;
		}

		return true;
	}

	private static void print(int[][] map) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}
}