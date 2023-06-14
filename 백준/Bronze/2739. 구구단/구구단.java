import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= 9; i++) {
			sb.append(N + " ");
			sb.append("*" + " ");
			sb.append(i+ " ");
			sb.append("="+ " ");
			sb.append(N*i);
			sb.append("\n");	
		}
		System.out.println(sb);
		
		
	}

}
