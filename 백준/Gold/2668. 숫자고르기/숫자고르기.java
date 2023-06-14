import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[] arr;
	static boolean[] first;
	static boolean[] second;
	static int cnt;
	static int max = Integer.MIN_VALUE;
	static boolean[] answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		answer = new boolean[N+1];
		cnt = 0;
		
		for (int i = 1; i <= N; i++) {
			first = new boolean[N+1];
			second = new boolean[N+1];
			
			boolean flag = true;
			if(!answer[i]) {
				solve(i);
			}
			
	      	for(int j=1; j<=N; j++) {
        		if(first[j] != second[j]) {
        			flag = false;
        		}
        	}
        	
        	if(flag) {
        		for(int j=1; j<=N; j++) {
        			if(first[j])
        				answer[j] = true;
        		}
        	}   	
		}
		
		
        for(int i=1; i<=N; i++) {
        	if(answer[i]) {
        		cnt += 1;
        		sb.append(i);
        		sb.append("\n");
        	}
        		
        }
        
        System.out.println(cnt);
        System.out.println(sb);
	}
	private static void solve(int k) {
		if(!first[k]) {
			first[k] = true;
			
			if(!second[arr[k]]) {
				second[arr[k]] = true;
				solve(arr[k]);
			}
		}

	}
	

}