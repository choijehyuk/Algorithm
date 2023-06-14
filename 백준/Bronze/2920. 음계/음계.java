import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[8];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int as = 0;
		int de = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i+1) {
				as++;
			}
			if(arr[i] == 8-i) {
				de++;
			}
		}
		if(as == 8) {
			System.out.println("ascending");
		}
		else if(de == 8) {
			System.out.println("descending");
		}
		else {
			System.out.println("mixed");
		}
	}

}
