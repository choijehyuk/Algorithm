import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] T = new long[N];

        for (int i = 0; i < N; i++) {
            T[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(T);

        long left = 0;
        long right = T[N - 1] * M;
        long answer = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < T.length; i++) {
                long cnt = mid / T[i];

                if (sum >= M) break;

                sum += cnt;
            }

            if (sum >= M) {
                right = mid - 1;
                answer = Math.min(mid, answer);
            } else left = mid + 1;
        }
        System.out.println(answer);
    }
}