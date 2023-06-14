import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			
			sb.append(s.charAt(0) + s.charAt(2) - 96 +  "\n");
			
		}
		System.out.println(sb);
	}

}
