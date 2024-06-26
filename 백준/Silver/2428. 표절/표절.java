import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        double[] fileSize = new double[N];

        for (int i = 0; i < N; i++) {
            fileSize[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(fileSize);
        long answer = 0;
        for (int i = 0; i < N; i++) {

            int start = i + 1;
            int end = N - 1;

            while (start <= end) {

                int mid = (start + end) / 2;
                if (fileSize[mid] * 0.9 <= fileSize[i]) start = mid + 1;
                else end = mid - 1;

            }

            answer += (start - i - 1);
        }

        System.out.println(answer);
    }
}