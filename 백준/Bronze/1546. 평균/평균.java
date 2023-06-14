import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		double avg = 0;
		double max = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			avg += (double)arr[i] / max * 100;
		}
		avg = avg / N;
		System.out.println(avg);
		
		
		

		

	}

}
