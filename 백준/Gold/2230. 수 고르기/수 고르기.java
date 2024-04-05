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
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = 0;

        int min = Integer.MAX_VALUE;
        while (right < N && left <= right) {
            int minus = arr[right] - arr[left];

            if (minus >= M) {
                left++;
                min = Math.min(min, minus);
            } else if (minus < M) right++;
        }
        System.out.println(min);
    }
}