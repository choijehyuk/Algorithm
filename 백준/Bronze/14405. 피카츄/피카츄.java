import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		boolean flag = true;
		int i = 0;
		while(i < s.length()) {

			char c = s.charAt(i);
			
			if(c == 'p') {
				if( i >= s.length()-1) {
					flag = false;
					break;
				}
				if(s.charAt(i+1) != 'i') {
					flag = false;
					break;
				}
				i += 2;
			}
			else if(c == 'k') {
				if( i >= s.length()-1) {
					flag = false;
					break;
				}
				if(s.charAt(i+1) != 'a') {
					flag = false;
					break;
				}
				i += 2;
			}
			else if(c == 'c') {
				if( i >= s.length()-2) {
					flag = false;
					break;
				}
				if(s.charAt(i+1) != 'h') {
					flag = false;
					break;
				}
				if(s.charAt(i+2) != 'u') {
					flag = false;
					break;
				}
				i+= 3;
			}
			else {
				flag = false;
				break;
			}
		}
		
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
}