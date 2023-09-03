import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int input = Integer.parseInt(st.nextToken());

            if (input == 1) {
                int score = Integer.parseInt(st.nextToken());
                if (score != 0) {
                    list.add(score);
                }

                int time = Integer.parseInt(st.nextToken()) - 1;
                if (time > 0) {
                    stack.add(time);
                } else {
                    answer += list.get(list.size() - 1);
                    list.remove(list.size() - 1);
                }

            } else if (stack.isEmpty() && input == 0) {
                continue;
            } else {
                int work = stack.pop();
                work -= 1;

                if (work > 0) {
                    stack.push(work);
                } else {
                    answer += list.get(list.size() - 1);
                    list.remove(list.size() - 1);
                }
            }
        }

        System.out.println(answer);
    }
}