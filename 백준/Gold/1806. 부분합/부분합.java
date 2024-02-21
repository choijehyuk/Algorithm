import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sum = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }


        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (sum[i] >= S) {
                answer = Math.min(answer, i + 1);
            }
            if (i == 0) continue;
            for (int j = i - 1; j >= 0; j--) {
                if (sum[i] - sum[j] >= S) {
                    answer = Math.min(answer, i - j);
                    break;
                }
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);

    }
}