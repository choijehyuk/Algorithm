import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R1 = Integer.parseInt(st.nextToken());
		int R2 = Integer.parseInt(st.nextToken());
		
		int S = R2 * 2 - R1;
		System.out.println(S);
		
	}

}