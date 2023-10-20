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
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] sushi = new int[d + 1];

        int cnt = 0;

        for (int i = 0; i < k; i++) {
            if (sushi[arr[i % N]] == 0) {
                cnt++;
            }
            sushi[arr[i % N]]++;
        }

        int max = cnt;

        for (int i = 0; i < N; i++) {
            if (max <= cnt) {
                if (sushi[c] == 0) {
                    max = cnt + 1;
                } else {
                    max = cnt;
                }
            }
            int end = (i + k) % N;
            sushi[arr[i]]--;
            if (sushi[arr[end]] == 0) {
                cnt++;
            }

            if (sushi[arr[i]] == 0) {
                cnt--;
            }
            sushi[arr[end]]++;
        }
        System.out.println(max);

    }

}