import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] arr;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			flag = false;
			for (int j = 0; j < N; j++) {
				if(arr[j] == num) {
					flag = true;
					break;
				}
			}
			if(flag) {
				sb.append(1 + "\n");
			}
			else {
				sb.append(0 + "\n");
			}
		}
		System.out.println(sb);
	}

}