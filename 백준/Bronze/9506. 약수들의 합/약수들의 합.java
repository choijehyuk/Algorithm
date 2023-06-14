import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == -1) {
				break;
			}
			int sum = 0;
			int end = 0;
			for (int i = 1; i < N; i++) {
				if(N % i == 0) {
					sum+= i;
					end = i;
				}
			}
			
			if(N == sum) {
				sb.append(N + " " + "=");
				for (int i = 1; i < N; i++) {
					if(N % i == 0) {
						if(i != end) {							
							sb.append(" " + i + " " + "+");
						}
						else {
							sb.append(" " + i);
						}
					}
				}
				sb.append("\n");
			}
			else {
				sb.append(N + " " + "is NOT perfect." + "\n");
			}
			
		}
		System.out.println(sb);
		
	}

}