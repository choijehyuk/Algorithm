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

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        double[] dp = new double[N];


        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        dp[0] = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] > dp[i - 1] * arr[i]) {
                dp[i] = arr[i];
            } else {
                dp[i] = dp[i - 1] * arr[i];
            }
        }

        Arrays.sort(dp);
        System.out.printf("%.3f", dp[N - 1]);
    }

}