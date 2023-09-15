import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 2];
        int cost = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        while (idx < N) {
            int cal = arr[idx];

            if (arr[idx] > 0) {
                cost += 3 * cal;
                cal = Math.min(arr[idx], arr[idx + 1]);

                cost += 2 * cal;
                arr[idx + 1] -= cal;
                int min = Math.min(arr[idx + 1], arr[idx + 2]);
                cal = Math.min(cal, arr[idx + 2] - min);

                cost += 2 * cal;
                arr[idx + 2] -= cal;

            }
            idx++;
        }
        System.out.println(cost);


    }
}