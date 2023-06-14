import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int answer;
	static int[] day;
	static int[] money;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		day = new int[n];
		money = new int[n];
		answer = 0;
		
		for (int i = 0; i <n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(st.nextToken());
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		// 각각의 날에 최대로 벌 수 있는 돈
		// 1일차 0 , 2일차 0, 3일차 10, 4일차 30 , 5일차 45, 6일차45 , 7일차45
		recursive(0,0);
		System.out.println(answer);
	}

	private static void recursive(int idx, int k) {
		//basis part
		if(idx == n) {
			if(answer < k) answer = k;
			return;
		}
		
		if(idx > n) {
			return;
		}
		//inductive part
		// 일을 하는 경우 // 날짜와 돈 추가
		recursive(idx+day[idx], k +money[idx]);
		// 일을 하지 않는 경우
		recursive(idx+1, k);
		
		
	}

}
