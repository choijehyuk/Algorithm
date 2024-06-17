import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            int C = Integer.parseInt(br.readLine());
            arr[i] = C;
        }

        Arrays.sort(arr, Comparator.reverseOrder());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if((i + 1) % 3 == 0 ) continue;

            answer += arr[i];
        }

        System.out.println(answer);

    }
}