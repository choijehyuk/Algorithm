import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];

        for (int i = 0; i < n - 1; i++) {
            if (dp[i] + arr[i + 1] > arr[i+1]) {
                dp[i + 1] = dp[i] + arr[i + 1];
            } else {
                dp[i + 1] = arr[i + 1];
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[n - 1]);

    }
}
