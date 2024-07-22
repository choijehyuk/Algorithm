import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[100000001];

        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(100000000); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 100000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        while (true) {

            boolean flag = true;

            if (!isPrime[N]) flag = false;

            String s = String.valueOf(N);

            for (int i = 0; i <= s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) flag = false;
            }

            if (!flag) N++;
            else {
                System.out.println(N);
                System.exit(0);
            }
        }

    }
}