import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[9];
		int max = 0;
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max) {
				max = arr[i];
				answer = i+1;
			}
		}
		System.out.println(max);
		System.out.println(answer);
		

	}

}
