import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                int check = Integer.parseInt(st.nextToken());

                if (set.contains(check)) {
                    sb.append("1" + "\n");
                } else {
                    sb.append("0" + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}