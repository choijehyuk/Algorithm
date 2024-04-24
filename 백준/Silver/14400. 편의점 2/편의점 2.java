import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x);
        Arrays.sort(y);

        int medianX = x[n / 2];
        int medianY = y[n / 2];

        long minX = 0;
        long minY = 0;

        for (int i = 0; i < n; i++) {
            minX += Math.abs(medianX - x[i]);
            minY += Math.abs(medianY - y[i]);
        }

        System.out.print(minX + minY);


    }
}