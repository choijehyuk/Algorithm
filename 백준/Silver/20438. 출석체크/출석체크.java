import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] v = new boolean[N + 3];
        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int code = Integer.parseInt(st.nextToken());

            if (list.contains(code)) continue;

            if (!v[code]) {
                for (int j = code; j < N + 3; j++) {
                    if (j % code == 0) {
                        if (!list.contains(j)) {
                            v[j] = true;
                        }
                    }
                }
            }
        }

        int[] sum = new int[N + 3];

        for (int i = 3; i < sum.length; i++) {
            sum[i] = sum[i - 1];

            if (!v[i]) sum[i] += 1;
            else sum[i] += 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(sum[E] - sum[S - 1]).append("\n");
        }

        System.out.println(sb);
    }
}