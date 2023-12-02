import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        String input = br.readLine();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            leftStack.push(input.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            switch (s.charAt(0)) {
                case 'L':
                    if (leftStack.isEmpty()) break;
                    rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    if (rightStack.isEmpty()) break;
                    leftStack.push(rightStack.pop());
                    break;
                case 'B':
                    if (leftStack.isEmpty()) break;
                    leftStack.pop();
                    break;
                case 'P':
                    leftStack.push(s.charAt(2));
                    break;
            }
        }
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);


    }

}