import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,S;
	static int[] arr;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0,0,new boolean[N]);
		System.out.println(answer);
		
	}
	private static void solve(int k, int idx, boolean[] v) {
		if(idx == arr.length) {
			if(k != 0) {
				int sum = 0;
				for (int i = 0; i < v.length; i++) {
					if(v[i]) {
						sum+= arr[i];
//						System.out.print(arr[i]+ " ");
					}
				}
//				System.out.println();
//				System.out.println("sum" + sum);
				if(sum == S) {
					answer++;
				}
			}
			
			return;

		}
		
		v[idx] = true;
		solve(k+1,idx+1,v);
		v[idx]= false;
		solve(k,idx+1,v);
	}
}