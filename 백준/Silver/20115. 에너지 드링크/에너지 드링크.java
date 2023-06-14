import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		double sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N-1; i++) {
			sum += arr[i] / 2.0;
		}
		
		sum += arr[N-1];
		
//		if(sum % 1 == 0) {
//			System.out.println((int)sum);
//		}
//		else {
//			System.out.println(sum);
//		}
		
		System.out.println(sum);
		
		
		

		
	}
}