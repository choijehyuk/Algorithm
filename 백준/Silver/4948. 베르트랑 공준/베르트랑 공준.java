import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        boolean[] isPrime = new boolean[300000];

        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i * i <= isPrime.length - 1; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= isPrime.length - 1; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int cnt = 0;
            for (int i = N + 1; i <= 2 * N; i++) {
                if (!isPrime[i]) cnt++;
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}