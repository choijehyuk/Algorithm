import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        double low = 0;
        double high = Math.min(L, Math.min(W, H));
        double mid = 0;

        for (int i = 0; i < 100000; i++) {
            mid = (low + high) / 2;

            if ((long) (L / mid) * (long) (W / mid) * (long) (H / mid) < N) {
                high = mid;
            } else {
                low = mid;
            }
        }

        System.out.println(low);
    }
}