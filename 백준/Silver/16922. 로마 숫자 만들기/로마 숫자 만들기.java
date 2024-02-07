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
        boolean[] v = new boolean[1001];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N - i; j++) {
                for (int k = 0; k <= N - i - j; k++) {
                    int num = N - i - j - k;
                    int sum = i + 5 * j + 10 * k + 50 * num;
                    v[sum] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i]) answer++;
        }
        System.out.println(answer);
    }
}