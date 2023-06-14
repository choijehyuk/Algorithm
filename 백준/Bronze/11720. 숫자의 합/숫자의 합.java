import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		String a = in.next();
		in.close();

		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += a.charAt(i) - '0';
		}
		System.out.print(sum);
	}
}
