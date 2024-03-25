import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num] = 1;
        }

        int sum = 0;
        for (int i = 1; i <= K; i++) {
            sum += arr[i];
        }

        int min = sum;
        for (int i = K + 1; i <= N; i++) {
            sum += arr[i] - arr[i - K];
            min = Math.min(min, sum);
        }
        System.out.println(min);
    }
}