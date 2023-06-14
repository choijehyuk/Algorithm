import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] arr;
	static StringBuffer sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuffer();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		solve(0,new int[M], new boolean[arr.length]);
		System.out.println(sb);
		
	}
	private static void solve(int k, int[] sel, boolean[] v) {
		if(k == sel.length) {
			//System.out.println(Arrays.toString(sel));
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = arr[i];
				solve(k+1,sel,v);
				v[i] = false;
			}
			
		}
	}

}