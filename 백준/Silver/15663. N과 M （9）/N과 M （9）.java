import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;
	static StringBuffer sb;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

//		for (int i = 0; i < N; i++) {
//			set.add(Integer.parseInt(st.nextToken()));
//		}
//		arr = new int[set.size()];
//		int cnt = 0;
//		Iterator<Integer> it = set.iterator();
//		while (it.hasNext()) {
//			arr[cnt] = it.next();
//			cnt++;
//		}
		// System.out.println(Arrays.toString(arr));

		solve(0, 0, new int[M], new boolean[N]);
		System.out.println(sb);
	}

	private static void solve(int k, int idx, int[] sel, boolean[] v) {
		if (k == sel.length) {
			//System.out.println(Arrays.toString(sel));
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			
			return;
		}

		int check = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!v[i]) {
				if (check != arr[i]) {
					v[i] = true;
					sel[k] = arr[i];
					check = arr[i];
					solve(k + 1, i, sel, v);
					v[i] = false;
				}
			}
		}
	}

}