import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

	static int N;
	static long answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty() && stack.peek() <= input) {
				stack.pop();
			}
			stack.add(input);
			
			answer += stack.size()-1;
		}
		System.out.println(answer);


		
	}

}