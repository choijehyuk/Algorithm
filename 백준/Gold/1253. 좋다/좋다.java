import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        Arrays.sort(arr);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;

            while (true) {

                if (left == i) {
                    left++;
                } else if (right == i) {
                    right--;
                }

                if (left >= right) break;

                int sum = arr[left] + arr[right];
                
                if (sum > arr[i]) {
                    right--;
                } else if (sum < arr[i]) {
                    left++;
                } else {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

}