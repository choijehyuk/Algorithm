import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int ring = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N - 1; i++) {
            int input = Integer.parseInt(st.nextToken());

            int div = 0;
            for (int j = 1; j <= Math.min(input, ring); j++) {
                if (input % j == 0 && ring % j == 0) div = j;
            }

            sb.append(ring / div).append("/").append(input / div).append("\n");
        }
        System.out.println(sb);

    }
}