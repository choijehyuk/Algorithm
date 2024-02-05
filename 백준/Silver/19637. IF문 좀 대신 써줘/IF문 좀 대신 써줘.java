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
        int M = Integer.parseInt(st.nextToken());
        String[] styles = new String[N];
        int[] powers = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String style = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            styles[i] = style;
            powers[i] = power;
        }

        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(br.readLine());

            int start = 0;
            int last = N - 1;

            while (start <= last) {
                int mid = (start + last) / 2;

                if (powers[mid] < input) {
                    start = mid + 1;
                } else {
                    last = mid - 1;
                }
            }

            sb.append(styles[start] + "\n");
        }
        System.out.println(sb);
    }
}