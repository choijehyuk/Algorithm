import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] sum = new int[N + 1];

        int x;

        st = new StringTokenizer(br.readLine());

        int now;

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            x = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + x;
            if (i < L) {
                now = sum[i];
            } else {
                now = sum[i] - sum[i - L];
            }

            if (129 <= now && now <= 138) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}