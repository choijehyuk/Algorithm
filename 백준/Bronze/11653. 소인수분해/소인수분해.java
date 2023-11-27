import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.exit(0);
        }

        while (true) {

            for (int i = 2; i <= N; i++) {
                if (N % i == 0) {
                    sb.append(i + "\n");
                    N /= i;
                    break;
                }
            }

            if (N == 1) {
                break;
            }
        }

        System.out.println(sb);
    }

}