import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int min = 1;
        int max = 1;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, arr[i]);
            max += arr[i];
        }

        int mid = 0;
        int cnt = 0;
        int sum = 0;

        while (min <= max) {
            mid = (min + max) / 2;

            sum = 0;
            cnt = 1;

            for (int i = 0; i < N; i++) {
                sum += arr[i];

                if (sum > mid) {
                    sum = arr[i];
                    cnt++;
                }
            }

            if (cnt > M) min = mid + 1;
            else max = mid - 1;
        }

        System.out.println(min);
    }
}