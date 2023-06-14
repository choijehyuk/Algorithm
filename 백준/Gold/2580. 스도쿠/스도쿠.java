import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {
	static int [][] map;
	static class Point{
		int r,c;
		Point(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
	static ArrayList<Point>list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		map = new int[9][9];
		
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				map[r][c]=sc.nextInt();
				if(map[r][c]==0)
					list.add(new Point(r, c));
			}
		}
		//System.out.println(list.size());
		//print(map);
		solve(0);
	}
	// k : 빈좌표 index 
	private static void solve(int k) {
		// basis part
		if(k==list.size()) {
			print(map);
			System.exit(0);
		}
		
		// inductive part
		int r = list.get(k).r;
		int c = list.get(k).c;
		
		for (int i = 1; i <= 9; i++) {
			// 가지치기
			if(check(r,c,i)) {
				map[r][c]=i;
				solve(k+1);
				map[r][c]=0;
			}
		
		}
	}
	// 중복되는 값이 없으면 true;
	// 아니면 false;
	private static boolean check(int r, int c, int index) {
		
		for (int i = 0; i < 9; i++) {
			if(map[r][i] == index || map[i][c] == index) return false;
		}
		
		int nr = (r/3) * 3;
		int nc = (c/3) * 3;
		
		for (int i = nr; i < nr+3; i++) {
			for (int j = nc; j < nc+3; j++) {
				if(map[i][j] == index) return false;
			}
		}	
		
		
		return true;
	}
	
	private static void print(int[][] map) {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
	}
	
}













