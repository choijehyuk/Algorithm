import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());

        int left = 0;
        int right = 0;
        long sum = arr[0];

        long answer = 0;
        while (right < N) {
            if (sum > K) {
                answer += N - right;
                sum -= arr[left];
                left++;
            } else {
                right++;
                if (right != N) {
                    sum += arr[right];
                }
            }
        }
        System.out.println(answer);
    }


}