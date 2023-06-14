
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 과일개수
		int L = Integer.parseInt(st.nextToken()); // 초기 길이
		int[] fruits = new int[N];
		int answer = L;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < fruits.length; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(fruits);
//		for (int i = 0; i < fruits.length-1; i++) {
//			if(fruits[0] != L) {
//				break;
//			}
//			
//			
//			if(fruits[i]+1 == fruits[i+1]) {
//				answer++;
//			}
//			else {
//				answer++;
//				break;
//			}
//			if(i == fruits.length-2) {
//				answer++;
//			}
//		}
//		System.out.println(answer);
		
		for (int i = 0; i < fruits.length; i++) {
//			if(fruits[0] < L) {
//				break;
//			}
			
			if(fruits[i] <= answer) {
				answer++;
				
			}

		}
		System.out.println(answer);
		
		
		
	}

}
