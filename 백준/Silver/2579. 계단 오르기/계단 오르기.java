import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] arr;
	static int[] jump;
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
				N = Integer.parseInt(br.readLine());
				arr = new int[N+1];
				jump = new int[N+1];
				
				for (int i = 1; i <= N; i++) {
					arr[i] = Integer.parseInt(br.readLine());
					sum += arr[i];
				}
				if(N ==1 || N == 2) {
					System.out.println(sum);
					System.exit(0);
				}
				
				
				int answer = dp();
				System.out.println(answer);
		
		
		
	}
	private static int dp() {
		jump[1] = arr[1];
		jump[2] = arr[2];
		jump[3] = arr[3];
		
		for (int i = 4; i <= N; i++) {
			jump[i] = Math.min(jump[i-2], jump[i-3]) + arr[i];
		}
		sum = sum - Math.min(jump[N-1], jump[N-2]);
		return sum;
	}

}