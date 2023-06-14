import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[26];
		String s = br.readLine().toUpperCase();
		
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) -'A' ;
            arr[num]++;
        }

        int max = -1;
        char ch = '?';
        
        for (int i = 0; i < s.length(); i++) {
        	arr[s.charAt(i)-'A']++;
        	if(max < arr[s.charAt(i)-'A']) {
        		max = arr[s.charAt(i)-'A'];
        		ch = s.charAt(i); 
        	}
        	else if(max == arr[s.charAt(i)-65]) {
        		ch = '?';
        	}
			
		}
        System.out.println(ch);
        
	}

}
