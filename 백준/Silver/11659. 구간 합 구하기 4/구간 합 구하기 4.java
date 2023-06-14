import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] sum = new int[n];
		int answer = 0;
		
		s = br.readLine();
		st = new StringTokenizer(s);
	
		for (int i = 0; i < n; i++) {
			if(i ==0) {
				arr[i] = Integer.parseInt(st.nextToken());
			}else {
				arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
			}
			
		}
		
		for (int i = 0; i < m; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			// 1~3번째 sum[2] - sum[-1]
			// 5~5번째 sum[4]-sum[3]
			// 2~4번째 sum[3] - sum[1]
			if(start == 1) {
				answer = arr[end-1];
			}
			else {
				answer = arr[end-1] - arr[start-2];
			}
			sb.append(answer);	
			sb.append("\n");
			
		}
		System.out.println(sb);
		

	}

}
