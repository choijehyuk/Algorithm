import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long answer = 0;

        if (N % 2 == 0) {
            for (int i = 0; i < N / 2; i++) {
                answer = Math.max(answer, arr[i] + arr[N - i - 1]);
            }
        } else {
            answer = arr[N - 1];
            for (int i = 0; i < (N - 1) / 2; i++) {
                answer = Math.max(answer, arr[i] + arr[N - i - 2]);
            }
        }

        System.out.println(answer);

    }
}