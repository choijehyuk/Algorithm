import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

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
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int elza = arr[i] + arr[j];
                int left = 0;
                int right = N - 1;

                while (left < right) {
                    if (left == i || left == j) {
                        left++;
                        continue;
                    }
                    if (right == i || right == j) {
                        right--;
                        continue;
                    }
                    int anna = arr[left] + arr[right];
                    min = Math.min(min, Math.abs(elza - anna));
                    if (elza > anna) {
                        left++;
                    } else if (elza < anna) {
                        right--;
                    } else {
                        System.out.println(0);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println(min);


    }
}