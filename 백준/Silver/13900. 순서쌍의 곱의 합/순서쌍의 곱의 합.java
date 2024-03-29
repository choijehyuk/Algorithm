import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        long answer = 0;

        st = new StringTokenizer(br.readLine());

        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());

            arr[i] = arr[i-1] + input;
            answer += arr[i-1] * input;
        }

        System.out.println(answer);
    }
}