import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int mul = A * B * C;
		String s = Integer.toString(mul);
		int zero = 0, one = 0, two = 0 , three = 0 , four = 0, five = 0, six = 0, seven = 0, eight = 0, nine =0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '0') {
				zero++;
			}
			else if(ch == '1') {
				one++;
			}
			else if(ch=='2') {
				two++;
			}
			else if(ch=='3') {
				three++;
			}
			else if(ch=='4') {
				four++;
			}
			else if(ch=='5') {
				five++;
			}
			else if(ch=='6') {
				six++;
			}
			else if(ch=='7') {
				seven++;
			}
			else if(ch=='8') {
				eight++;
			}
			else if(ch=='9') {
				nine++;
			}
			
		}
		System.out.println(zero);
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		System.out.println(four);
		System.out.println(five);
		System.out.println(six);
		System.out.println(seven);
		System.out.println(eight);
		System.out.println(nine);
	}

}
