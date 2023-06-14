import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[] arr;
	static double sum;
	static int avg;
	static int center;
	static int mode;
	static int range;
	static int cnt;
	static int max = Integer.MIN_VALUE;
	static boolean flag = false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		if(N==1) {
			mode =arr[0];
		}
		for (int i = 0; i < N-1; i++) {
			if(arr[i] == arr[i+1]) {
				cnt++;
			}
			else {
				cnt = 0;
			}
			
			if(max < cnt) {
				max = cnt;
				mode = arr[i];
				flag = true;
			}
			else if(max == cnt && flag) {
				mode = arr[i];
				flag = false;
			}			
		}
		//avg = Math.round(sum / N);
		center = arr[N/2];		
		range = arr[N-1] - arr[0];
	
		System.out.println(Math.round(sum / N));
		System.out.println(center);
		System.out.println(mode);
		System.out.println(range);
		
		
	}

}