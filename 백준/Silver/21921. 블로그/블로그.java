import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int[] sum = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < X; i++) {
            sum[X - 1] += arr[i];
        }

        for (int i = X; i < N; i++) {
                sum[i] += arr[i];
                sum[i] += sum[i - 1];
                sum[i] -= arr[i - X];
        }

        int cnt = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            if (sum[i] > max) {
                max = sum[i];
                cnt = 1;
            } else if (sum[i] == max) cnt++;
        }

        if (max == 0) {
            System.out.println("SAD");
            System.exit(0);
        }

        System.out.println(max);
        System.out.println(cnt);
    }
}