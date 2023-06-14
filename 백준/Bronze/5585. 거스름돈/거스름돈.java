import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int money = 1000 - Integer.parseInt(br.readLine());
		int answer = 0;
		
		answer += money / 500;
		money %= 500;
		
		answer += money / 100;
		money %= 100;
		
		answer += money / 50;
		money %= 50;
		
		answer += money / 10;
		money %= 10;
		
		answer += money / 5;
		money %= 5;
		
		answer += money / 1;
		money %= 1;
		
		System.out.println(answer);
		
	}
}