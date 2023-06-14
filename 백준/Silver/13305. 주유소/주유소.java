import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] road;
	static int[] price;
	static int sum;
	static int minprice = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		road = new int[N-1];
		price = new int[N];		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < road.length; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < price.length; i++) {
			price[i] = Integer.parseInt(st.nextToken());
 		}
		
		sum += road[0] * price[0];
		
		minprice = price[0];
				
		for (int i = 1; i < N-1; i++) {
			if(price[i] < minprice ) {
				minprice = price[i];
			}
			sum += minprice * road[i];
		}
		System.out.println(sum);
		
	}

}