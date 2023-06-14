import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = br.readLine();
		for (int i = 0; i < s.length() / 2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-i-1)) {
				System.out.println(0);
				System.exit(0);
			}
		}
		System.out.println(1);
		
		

		
	}
}