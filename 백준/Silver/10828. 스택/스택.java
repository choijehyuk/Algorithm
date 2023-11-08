import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String input = st.nextToken();

            if(input.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }
            else if(input.equals("pop")){
                if(stack.size() == 0){
                    sb.append("-1\n");
                }
                else{
                    sb.append(stack.pop()+ "\n");
                }
            }
            else if(input.equals("size")){
                sb.append(stack.size() + "\n");
            }
            else if(input.equals("empty")){
                if(stack.isEmpty()){
                    sb.append("1\n");
                }
                else{
                    sb.append("0\n");
                }
            }
            else if(input.equals("top")){
                if(stack.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(stack.peek() + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}