import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] screen = new int[N];
        int[] basket = new int[M];

        int J = Integer.parseInt(br.readLine());

        int left = 0;
        int right = left + M - 1;

        int dist = 0;
        for (int i = 0; i < J; i++) {
            int apple = Integer.parseInt(br.readLine()) - 1;

            if (apple < left) {
                int diff = left - apple;
                dist += diff;
                left -= diff;
                right -= diff;
            } else if (apple > right) {
                int diff = apple - right;
                dist += diff;
                right += diff;
                left += diff;
            }
        }
        System.out.println(dist);

    }
}