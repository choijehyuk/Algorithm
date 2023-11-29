import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        primeNumber(N, K);

    }

    private static void primeNumber(int N, int K) {
        int[] arr = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= N; i++) {
            if (arr[i] == 0) continue;

            for (int j = i; j <= N; j += i) {
                if (arr[j] != 0) {
                    arr[j] = 0;
                    K--;
                   
                    if (K == 0) {
                        System.out.print(j);
                        return;
                    }
                }
            }
        }
    }

}