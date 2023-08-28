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

        int dp[] = new int[1001];

        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;

        for (int i = 5; i < 1001; i++) {
            if (dp[i - 1] + dp[i - 3] + dp[i - 4] < 3) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }

        if (dp[N] == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

    }

}