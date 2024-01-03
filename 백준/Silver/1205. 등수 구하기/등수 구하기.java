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

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println("1");
            System.exit(0);
        }

        st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[N + 1];

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr[arr.length - 1] = score;

        Arrays.sort(arr, Collections.reverseOrder());

        if (P < arr.length && arr[P] >= score) {
            System.out.println("-1");
            System.exit(0);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == score) {
                System.out.println(i + 1);
                System.exit(0);
            }
        }


    }

}