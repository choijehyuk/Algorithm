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
        int[] check = new int[100001];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                answer++;
            }
        }
        System.out.println(answer);
    }


}