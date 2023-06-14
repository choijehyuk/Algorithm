import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	static char[] input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		Arrays.sort(input);
		
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[input.length-1-i]);
		}
	}

}
