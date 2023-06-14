import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		int answer = 0;
		boolean flag = false;
		while(st.hasMoreTokens()) {
			int sum = 0;
			
			StringTokenizer stt = new StringTokenizer(st.nextToken(), "+");
			
			while(stt.hasMoreTokens()) {
				sum += Integer.parseInt(stt.nextToken());
			}
			
			if(!flag) {
				answer = sum;
			}
			else {
				answer -= sum;
			}
			flag = true;
		}
		System.out.println(answer);
		
		
		
	}

}