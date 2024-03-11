import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int[] answer = new int[6];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (idx == 6) break;
                answer[idx++] = Integer.parseInt(arr[i] + "" + arr[j]);
                answer[idx++] = Integer.parseInt(arr[j] + "" + arr[i]);
            }
        }
        Arrays.sort(answer);

        System.out.println(answer[2]);
    }
}