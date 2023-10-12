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

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, (o1, o2) -> {
                return o1[0] - o2[0];
            });

            int max = arr[0][1];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i][1] > max) {
                    N--;
                    continue;
                }
                max = arr[i][1];

            }
            sb.append(N + "\n");
        }
        System.out.println(sb);
    }

}