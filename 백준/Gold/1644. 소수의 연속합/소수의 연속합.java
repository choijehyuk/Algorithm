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

        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[N + 1];
        int answer = 0;

        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) list.add(i);
        }

        if(N == 2){
            System.out.println("1");
            System.exit(0);
        }

        int left = 0;
        int right = 1;

        while (right < list.size()) {
            int sum = 0;

            for (int i = left; i <= right; i++) {
                sum += list.get(i);
            }

            if (sum < N) right++;
            else if (sum > N) left++;
            else {
                answer++;
                left++;
            }
        }
        System.out.println(answer);
    }
}