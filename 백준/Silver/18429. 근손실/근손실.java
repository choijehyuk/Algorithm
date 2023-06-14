import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,K;
	static int[] arr;
	static boolean[] v;
	static int weight = 500;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		v = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0,new int[N]);
		System.out.println(answer);
		
		
	}
	private static void solve(int k, int[] sel) {
		if(k == sel.length) {
			//System.out.println(Arrays.toString(sel));
			weight = 500;
			int cnt = 0;
			for (int i = 0; i < sel.length; i++) {
				weight = weight - K + arr[sel[i]];
				//System.out.println(weight);
				if(weight < 500 ) {
					break;
				}
				else {
					cnt++;
				}
			}
			
			if(cnt == sel.length)
				answer++;
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = i;
				solve(k+1,sel);
				v[i] = false;
			}
		}
	}

}
