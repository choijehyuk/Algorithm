import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String[][] star = new String[n][n];
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star.length; j++) {
				star[i][j] = " ";
			}
		}
		recursive(star, 0, 0, n);

		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star.length; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void recursive(String[][] star, int x, int y, int k) {
		if (k == 1) {
			star[x][y] = "*";
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i != 1 || j != 1) {
					recursive(star, x + k / 3 * i, y + k / 3 * j , k / 3);
				}
			}
		}

	}
}
