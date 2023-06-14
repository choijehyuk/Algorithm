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
		int N,M,i,j,k;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		
		for (int l = 0; l < M; l++) {
			st = new StringTokenizer(br.readLine());
			
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			for (int l2 = i; l2 <= j; l2++) {
				arr[l2] = k;
			}
		}
		
		for (int l = 1; l <= N; l++) {
			System.out.print(arr[l] + " ");
		}
		
		
		
		
	}

}