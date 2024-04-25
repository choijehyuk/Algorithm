import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(":");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int min = Math.min(n, m);

        for (int i = min; i > 0; i--) {
            if (n % i == 0 && m % i == 0) {
                sb.append(n / i).append(":").append(m / i);
                break;
            }
        }
        System.out.println(sb);
    }
}