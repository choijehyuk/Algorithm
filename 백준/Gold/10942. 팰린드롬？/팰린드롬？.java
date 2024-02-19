import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if (S == E) {
                sb.append(1).append("\n");
                continue;
            }
            int num = 1;
            boolean flag = true;
            while (S <= E - num) {
                if (arr[S - 1] == arr[E - num]) {
                    S++;
                    num++;
                } else {
                    flag = false;
                    break;
                }
            }
            sb.append(flag ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }
}