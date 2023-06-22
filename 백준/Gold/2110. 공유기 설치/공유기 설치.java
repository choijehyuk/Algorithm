import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, C;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr[N - 1] - arr[0];
        int mid, start, distance;
        int cnt;
        while (left <= right) {
            mid = (left + right) / 2;
            start = arr[0];
            cnt = 1;

            for (int i = 0; i < N; i++) {
                distance = arr[i] - start;
                if (distance >= mid) {
                    cnt++;
                    start = arr[i];
                }
            }

            if (cnt >= C) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
        
    }
}