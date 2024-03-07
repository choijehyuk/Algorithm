import java.util.*;
import java.io.*;

public class Main {
    static int H, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];
        int[] rain = new int[W];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            rain[i] = max;
        }

        max = 0;
        int answer = 0;

        for (int i = W - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            rain[i] = Math.min(max, rain[i]);
            answer += rain[i] - arr[i];
        }

        System.out.println(answer);
    }
}