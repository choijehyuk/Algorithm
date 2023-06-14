import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] tree;
	//static int sum;
	static int answer;
	static int max = Integer.MIN_VALUE;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < tree.length; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if (tree[i] > max) {
				max = tree[i];
			}
		}
		
		while(min < max) {
			int mid = (min + max) / 2;
			long sum = 0;
			
            for (int x : tree) {
                if (x > mid) {
                    sum += x - mid;
                }
            }

			if(sum < M) {
				max = mid;
			}
			else {
				min = mid + 1;
				answer = Math.max(answer, mid);
			}
			
		}
		System.out.println(answer);
	}
}
