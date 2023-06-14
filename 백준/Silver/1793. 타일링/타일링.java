import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

	static int N;
	static BigInteger[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while( (str = br.readLine()) != null) {
			N = Integer.parseInt(str);
			arr = new BigInteger[251];
			
			BigInteger answer = dp();
			System.out.println(answer);
		}
		
		

	}
	private static BigInteger dp() {
		arr[0]= new BigInteger("1");
		arr[1]= new BigInteger("1");
		arr[2]= new BigInteger("3");

		for (int i = 3; i <= N; i++) {
			arr[i] = arr[i-1].add(arr[i-2].multiply(new BigInteger("2")));
		}
		
		return arr[N];
		
	}

}