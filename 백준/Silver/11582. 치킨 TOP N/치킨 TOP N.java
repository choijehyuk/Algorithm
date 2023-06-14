import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] arr;
	static int[] sort;
	static int div;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		K = Integer.parseInt(br.readLine());

		div = N / K; // div = 4 , K = 2 , N = 8

		sort = new int[div];

		int cnt = 0;
		int temp = 0;
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < div; j++) {
				sort[j] = arr[cnt];
				cnt++;
			}
			Arrays.sort(sort);
//			for (int j = 0; j < div; j++) {
//				arr[temp] = sort[j];
//				temp++;
//			}
			for (int j = 0; j < div; j++) {
				sb.append(sort[j] + " ");
			}

		}

//		for (int i = 0; i < N; i++) {
//			System.out.print(arr[i] + " ");
//		}
		System.out.println(sb);

	}

}