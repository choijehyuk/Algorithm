import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            long n = Long.parseLong(br.readLine());
            if (n < 2)
                n = 2;

            L:while (true) {
                for (long j = 2; j * j <= n; j++) {
                    if (n % j == 0) {
                        n++;
                        continue L;
                    }
                }
                sb.append(n).append("\n");
                break;
            }

        }
        System.out.println(sb);
    }

}