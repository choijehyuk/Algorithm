import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());

        long Z = Y * 100 / X;

        int left = 0;
        int right = 1000000000;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if ((Y + mid) * 100 / (X + mid) != Z) {
                answer = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        System.out.println(answer);
    }
}