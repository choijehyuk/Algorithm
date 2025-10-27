import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        long sum = 0;
        long xor = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int query = Integer.parseInt(st.nextToken());

            if (query == 1) {
                long num = Integer.parseInt(st.nextToken());
                sum += num;
                xor ^= num;
            } else if (query == 2) {
                long num = Integer.parseInt(st.nextToken());
                sum -= num;
                xor ^= num;
            } else if (query == 3) {
                sb.append(sum).append("\n");
            } else if (query == 4) {
                sb.append(xor).append("\n");
            }
        }

        System.out.println(sb);
    }

}
