import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int yaksoo = 0;
		int baesoo = 0;
		
		for (int i = 1; i <= Math.min(A, B); i++) {
			if(A % i == 0 && B % i == 0) {
				yaksoo = i;
			}
		}
		baesoo = A * B / yaksoo;
		System.out.println(yaksoo);
		System.out.println(baesoo);
	}

}