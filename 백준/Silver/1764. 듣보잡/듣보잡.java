import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;


		ArrayList<String> answer = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		
		for (int i = 0; i < m; i++) {
			String temp = br.readLine();
			if(set.contains(temp)) {
				answer.add(temp);
				cnt++;
			}
		}
		Collections.sort(answer);
		System.out.println(cnt);
		for (String s : answer) {
			System.out.println(s);
		}
	

	}

}
