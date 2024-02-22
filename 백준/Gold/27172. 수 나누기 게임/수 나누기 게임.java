import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        boolean[] card = new boolean[1000001];
        int[] answer = new int[1000001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            card[arr[i]] = true;
        }

        for (int i : arr) {
            for (int j = i * 2; j < 1000001; j += i) {
                if (card[j]) {
                    answer[i]++;
                    answer[j]--;
                }
            }
        }

        for (int i : arr) {
            System.out.print(answer[i] + " ");
        }
    }
}