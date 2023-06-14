import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		String N = br.readLine();
		int[] arr = new int[N.length()];
		int sum = 0;
		
		for (int i = 0; i < N.length(); i++) {
			sum += N.charAt(i)-'0';
			arr[i] = N.charAt(i)-'0';
		}
		Arrays.sort(arr);
		
		if(arr[0] == 0 && sum % 3 == 0) {
			for (int i = arr.length-1; i >= 0; i--) {
				System.out.print(arr[i]);
			}
		}
		else {
			System.out.println(-1);
		}
		
		
		
		
		

		
	}
}