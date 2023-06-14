import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			if(N ==1) {
				System.out.println("1");
				continue;
			}
			arr = new int[N+1];
			int answer = dp();
			//System.out.println(Arrays.toString(arr));
			System.out.println(answer);
		}
	}
	private static int dp() {
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		if(N >= 3) {			
			for (int i = 3; i <= N; i++) {
				arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
			}
		}
		return arr[N];
	}
}