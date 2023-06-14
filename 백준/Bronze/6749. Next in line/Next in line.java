import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int Y = Integer.parseInt(br.readLine());
		int X = Integer.parseInt(br.readLine());
		int minus = X-Y;
		System.out.println(X+minus);
	}

}