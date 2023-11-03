import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = K;
        int sum = 0;

        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        int max = sum;
        while (right < N) {

            sum -= arr[left];
            sum += arr[right];

            left++;
            right++;
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }


}