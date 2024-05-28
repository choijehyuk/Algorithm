import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] sum = new long[N + 1];

        for (int i = N - 1; i >= 0; i--) {
            sum[i] += sum[i + 1] + arr[i];
        }

        long answer = 0;

        for (int i = 0; i < N; i++) {
            answer += arr[i] * sum[i + 1];
            answer %= 1000000007;
        }

        System.out.println(answer);
    }
}