import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());

		long cnt = max - min + 1;
		int answer = 0;
		int[] arr = new int[1000002];
		
		for(long start = 2; start * start <= max; start++) {
			long jaegob = start * start;
			long temp = min / jaegob;
			if(min % jaegob != 0) {
				temp++;
			}
			//System.out.println(temp);
			for (long i = temp ; i * jaegob <= max  ; i++) {
				//System.out.println(i * jaegob - min + 1);
				//System.out.println(i * jaegob - min);
				//System.out.println(i + " "  + jaegob);
				arr[(int)(i * jaegob - min + 1)] = 1;
			}
			
		}
			
		
		for (int i = 1; i <= cnt; i++) {
			if(arr[i] == 0) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
