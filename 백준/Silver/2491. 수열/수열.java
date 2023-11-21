import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int big = 1;
        int max = 1;

        for (int i = 0; i < N - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                big++;
            } else {
                big = 1;
            }
            max = Math.max(max, big);
        }

        int small = 1;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                small++;
            } else {
                small = 1;
            }
            max = Math.max(max, small);
        }
        System.out.println(max);


    }
}