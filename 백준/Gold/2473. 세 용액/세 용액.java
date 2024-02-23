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

        long minVal = Long.MAX_VALUE;
        long[] answer = new long[3];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                long sum = arr[i] + arr[j];

                int idx = Arrays.binarySearch(arr, -sum);
                if (idx < 0) idx = -(idx + 1);

                if (idx == arr.length) idx--;
                long min = Math.abs(sum + arr[idx]);

                if (idx != 0 && idx - 1 > j) {
                    if (Math.abs(min) > Math.abs(sum + arr[idx - 1])) {
                        idx--;
                    }
                    min = Math.min(Math.abs(min), Math.abs(sum + arr[idx]));
                }

                if (Math.abs(minVal) > Math.abs(min)) {
                    while (idx <= j) idx++;
                    if (Math.abs(minVal) > Math.abs(sum + arr[idx])) {
                        minVal = Math.abs(min);
                        answer[0] = arr[i];
                        answer[1] = arr[j];
                        answer[2] = arr[idx];
                    }
                }
            }
        }

        Arrays.sort(arr);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}