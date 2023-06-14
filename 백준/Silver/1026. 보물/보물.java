import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		Integer[] b = new Integer[n];
		int max = 0;
		int sum = 0;
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		s = br.readLine();
		st = new StringTokenizer(s);
		
		for (int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
//		int[] check = new int[n];
//		
//		for (int i = 0; i < n; i++) {
//			check[i] = b[i];
//		}
//		
//		for (int i = 0; i < n; i++) {
//			
//		}
		
		Arrays.sort(b, Collections.reverseOrder());
		Arrays.sort(a);
		for(int i =0; i<n; i++) {
			sum += a[i] * b[i];
		}
		System.out.println(sum);
	}

}
