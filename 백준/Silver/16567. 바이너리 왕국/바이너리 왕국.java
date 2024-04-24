import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        int cnt = 0;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] == 1 && !flag) {
                cnt++;
                flag = true;
            } else if (arr[i] == 0) flag = false;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int test = Integer.parseInt(st.nextToken());

            if (test == 0) sb.append(cnt).append("\n");

            else {
                int road = Integer.parseInt(st.nextToken()) - 1;

                if (arr[road] == 1) continue;
                arr[road] = 1;

                if (road == 0) {
                    if (arr[road + 1] == 0) cnt++;
                } else if (road == N - 1) {
                    if (arr[road - 1] == 0) cnt++;
                } else {
                    if (arr[road - 1] == 0 && arr[road + 1] == 0) cnt++;
                    else if (arr[road - 1] == 1 && arr[road + 1] == 1) cnt--;
                }
            }
        }

        System.out.println(sb);

    }
}