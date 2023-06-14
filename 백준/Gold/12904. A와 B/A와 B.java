import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		while(S.length() < T.length()) {
			String change ="";
			if(T.charAt(T.length()-1) == 'A') {
				for (int i = 0; i < T.length()-1; i++) {
					change += T.charAt(i);
				}
				T = change;
			}
			else if(T.charAt(T.length()-1) == 'B') {
				for (int i = 0; i < T.length()-1; i++) {
					change += T.charAt(i);
				}
				T = change;
				change = "";
				
				//System.out.println(T);
				for (int i = T.length()-1; i >= 0; i--) {
					change += T.charAt(i);
				}
				T = change;
			}
		}
		if(S.equals(T)) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}

}
