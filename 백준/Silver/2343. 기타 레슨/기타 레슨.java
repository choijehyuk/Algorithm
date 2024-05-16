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

        int[] arr = new int[N];
        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, arr[i]);
            end += arr[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += arr[i];
            }

            if (sum != 0) cnt++;
            if (cnt <= M) end = mid - 1;
            else start = mid + 1;
        }

        System.out.println(start);
    }
}