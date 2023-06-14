import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long S = Long.parseLong(br.readLine());
		
		long sum = 0;
		long n = 0;
		while(true) {
			sum += n;
			if(sum> S) {
				System.out.println(n-1);
				break;
			}
			n++;
		}
	}

}