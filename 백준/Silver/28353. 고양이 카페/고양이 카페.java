import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int end = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (i >= end) {
                break;
            }

            while (true) {
                if (arr[i] + arr[end] <= K) {
                    answer++;
                    end--;
                    break;
                }
                if (i >= end) {
                    break;
                }
                end--;
            }
        }
        System.out.println(answer);
    }


}