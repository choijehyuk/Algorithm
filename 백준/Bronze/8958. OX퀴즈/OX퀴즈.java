import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			int add = 0;
			int score = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == 'O') {
					add++;
					score += add;
				} else {
					add = 0;
				}
			}
			sb.append(score);
			sb.append("\n");
		}
		System.out.print(sb);

	}

}
