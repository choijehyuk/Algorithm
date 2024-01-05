import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = new int[1000001];
        boolean[] v = new boolean[10];

        // 26195083까지
        int idx = 1;
        for (int i = 1; i < 26195084; i++) {
            if (isDistinctDigits(i, v)) {
                answer[idx] = i;
                idx++;
            }

        }

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                System.out.println(sb);
                System.exit(0);
            }

            //sb.append(list.get(N - 1) + "\n");
            sb.append(answer[N] + "\n");
        }
    }

    private static boolean isDistinctDigits(int num, boolean[] v) {
        for (int i = 0; i < 10; i++) {
            v[i] = false;
        }

        while (num > 0) {
            int digit = num % 10;
            if (v[digit]) {
                return false;
            }
            v[digit] = true;
            num /= 10;
        }

        return true;
    }
}